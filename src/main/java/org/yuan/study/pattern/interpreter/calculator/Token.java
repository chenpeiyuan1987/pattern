package org.yuan.study.pattern.interpreter.calculator;

public class Token {
	
	public Token(String expr) {
		this.expr = expr;
		this.index = 0;
	}

	public String next() {
		char ch = expr.charAt(index++);
		return String.valueOf(ch);
	}
	
	public boolean hasNext() {
		return index < expr.length();
	}
	
	public int size() {
		return expr.length();
	}
	
	private String expr;
	private int index;
}
