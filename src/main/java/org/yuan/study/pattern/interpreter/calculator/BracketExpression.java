package org.yuan.study.pattern.interpreter.calculator;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 括号表达式
 * @author Yuan
 *
 */
public class BracketExpression implements Expression {

	public BracketExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public BigDecimal interpret(Map<String, BigDecimal> vars) {
		return expression.interpret(vars);
	}

	// 表达式
	private Expression expression;
}
