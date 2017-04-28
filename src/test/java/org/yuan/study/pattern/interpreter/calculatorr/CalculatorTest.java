package org.yuan.study.pattern.interpreter.calculatorr;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yuan.study.pattern.interpreter.calculator.Calculator;

public class CalculatorTest {
	private Map<String,BigDecimal> vars;
	
	@Before
	public void before() {
		vars = new HashMap<String,BigDecimal>();
		vars.put("a", new BigDecimal(1));
		vars.put("b", new BigDecimal(2));
		vars.put("c", new BigDecimal(3));
		vars.put("d", new BigDecimal(4));
		vars.put("3", new BigDecimal(5));
	}

	@Test
	public void testAdd() {
		String expr = "a+b+c";
		
		Assert.assertEquals(new BigDecimal(6), calc(expr));
	}
	
	@Test
	public void testSub() {
		String expr = "a-b-c";
		
		Assert.assertEquals(new BigDecimal(-4), calc(expr));
	}
	
	private BigDecimal calc(String expr) {
		return calc(expr, vars);
	}
	
	private BigDecimal calc(String expr, Map<String,BigDecimal> vars) {
		Calculator calculator = new Calculator(expr);
		BigDecimal result = calculator.run(vars);
		
		return result;
	}
}
