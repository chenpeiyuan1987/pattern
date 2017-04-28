package org.yuan.study.pattern.interpreter.calculator;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 乘运算符
 * @author Yuan
 *
 */
public class DivOperatorExpression extends OperatorExpression {

	@Override
	public BigDecimal interpret(Map<String, BigDecimal> vars) {
		BigDecimal left = getLeft().interpret(vars);
		BigDecimal right = getRight().interpret(vars);
		BigDecimal result = left.divide(right);
		return result;
	}
	
	@Override
	public int getLevel() {
		return LEVEL;
	}

	// 运算符字符
	public static final char SYMBOL = '/';
	// 运算符级别
	private static final int LEVEL = 10;
}
