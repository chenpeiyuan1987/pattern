package org.yuan.study.pattern.interpreter.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Yuan
 *
 */
public class Calculator {
	
	public Calculator(String expr) {
		varList = new ArrayList<String>();
		expression = parse(expr);
	}
	
	/**
	 * 计算结果
	 * @param vars
	 * @return
	 */
	public BigDecimal run(Map<String, BigDecimal> vars) {
		return expression.interpret(vars);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getVarList() {
		return varList;
	}
	
	/**
	 * 组装表达式
	 * @param list
	 * @return
	 */
	private Expression assemble(List<Expression> list) {
		Stack<Expression> stack = new Stack<Expression>();
		
		int level = OperatorExpression.MAX_LEVEL;
		while(level >= OperatorExpression.MIN_LEVEL) {
			stack.clear();
			
			for(int i=0; i<list.size(); i++) {
				Expression expr = list.get(i);
				
				/*
				if(expr instanceof OperatorExpression) {
					OperatorExpression oper = (OperatorExpression)expr;
					if(level == oper.getLevel()) {
						oper.setLeft(stack.pop());
						oper.setRight(list.get(++i));
						stack.push(oper);
					}
					else {
						stack.push(expr);
					}
				}
				else {
					stack.push(expr);
				}
				*/
				if(expr instanceof OperatorExpression) {
					OperatorExpression oper = (OperatorExpression)expr;
					if(level == oper.getLevel()) {
						oper.setLeft(stack.pop());
						oper.setRight(list.get(++i));
					}
				}
				stack.push(expr);
			}
			
			level--;
			list.clear();
			list.addAll(stack);
		}
		
		return stack.pop();
	}
	
	/**
	 * 拆分表达式
	 * @param token
	 * @return
	 */
	private List<Expression> separate(Token token) {
		List<Expression> list = new ArrayList<Expression>();
		
		while(token.hasNext()) {
			String ch = token.next();
			
			if("(".equals(ch)) {
				List<Expression> temp = separate(token);
				Expression expr = assemble(temp);
				list.add(new BracketExpression(expr));
			} 
			else
			if(")".equals(ch)) {
				return list;
			}
			else
			if(OPERATORS.containsKey(ch)) {
				try {
					Class<?> clazz = OPERATORS.get(ch);
					Expression expr = (Expression)clazz.newInstance();
					list.add(expr);
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				list.add(new VariableExpression(ch));
				varList.add(ch);
			}
		}
		
		return list;
	}
	
	/**
	 * 解析表达式
	 * @param expr
	 * @return
	 */
	private Expression parse(String expr) {
		Token token = new Token(expr);
		List<Expression> list = separate(token);
		Expression expression = assemble(list);
		
		return expression;
	}

	// 运算符
	private Expression expression;
	// 变量列表
	private List<String> varList;
	
	private static final Map<String,Class<?>> OPERATORS;
	static {
		OPERATORS = new HashMap<String,Class<?>>();
		OPERATORS.put(String.valueOf(AddOperatorExpression.SYMBOL), AddOperatorExpression.class);
		OPERATORS.put(String.valueOf(SubOperatorExpression.SYMBOL), SubOperatorExpression.class);
	}
}
