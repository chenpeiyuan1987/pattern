package org.yuan.study.pattern.interpreter.calculator;

/**
 * 运算符表达式
 * @author Yuan
 *
 */
abstract
public class OperatorExpression implements Expression {

	public Expression getLeft() {
		return left;
	}
	
	public void setLeft(Expression left) {
		this.left = left;
	}
	
	public Expression getRight() {
		return right;
	}
	
	public void setRight(Expression right) {
		this.right = right;
	}
	
	abstract
	public int getLevel();
	
	private Expression left;
	private Expression right;
	
	/** 最小级别 */
	public static final int MIN_LEVEL = 1;
	/** 最大级别 */
	public static final int MAX_LEVEL = 100;
}
