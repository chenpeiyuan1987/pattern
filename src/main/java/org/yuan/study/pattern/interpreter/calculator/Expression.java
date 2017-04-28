package org.yuan.study.pattern.interpreter.calculator;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 表达式
 * @author Yuan
 */
public interface Expression {
	
	/**
	 * 计算表达式结果
	 * @param vars
	 * @return
	 */
	BigDecimal interpret(Map<String,BigDecimal> vars);
}
