package org.yuan.study.pattern.interpreter.calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String next = "是";
		while("是".equals(next)) {
			String expr = getExpression();
			Calculator calculator = new Calculator(expr);
			Map<String,BigDecimal> vars = getVariables(calculator.getVarList());
			BigDecimal result = calculator.run(vars);
			System.out.println("计算结果：" + result);
			
			System.out.print("是否继续：");
			next = scan.nextLine();
		}
	}
	
	// 获取公式
	private static String getExpression() {
		System.out.print("请输入公式：");
		String expr = scan.nextLine();
		
		return expr;
	}
	
	// 获取变量值
	private static Map<String,BigDecimal> getVariables(List<String> keys) {
		Map<String,BigDecimal> vars = new HashMap<String,BigDecimal>();
		
		for(String key : keys) {
			System.out.printf("请输入%s的值：", key);
			String line = scan.nextLine();
			BigDecimal val = new BigDecimal(line.trim());
			vars.put(key, val);
		}
		
		return vars;
	}

}
