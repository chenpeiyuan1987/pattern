package org.yuan.study.pattern.interpreter.calculator;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 变量表达式
 * @author Yuan
 *
 */
public class VariableExpression implements Expression {
	
	public VariableExpression(String name) {
		this.name = name;
	}

	@Override
	public BigDecimal interpret(Map<String, BigDecimal> vars) {
		return vars.get(name);
	}

	// 变量名称
	private String name;
}
