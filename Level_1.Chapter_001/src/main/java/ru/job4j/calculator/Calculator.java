package ru.job4j.calculator;

/**
 * Class Calculator.
 * @author Anastasia Gladun (netmislei@mail.ru)
 */
public class Calculator {
	/**
	* Class variable.
	*/
	private double result;
	/**
	 * Return result.
	 * @return result
	 */
	public double getResult() {
		return this.result;
	}
	/**
	 * Add.
	 * @param first first operand
	 * @param second second operand
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * Substruct.
	 * @param first first operand
	 * @param second second operand
	 */
	public void substruct(double first, double second) {
		this.result = first - second;
	}
	/**
	 * Div.
	 * @param first first operand
	 * @param second second operand
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	 * Multiply.
	 * @param first first operand
	 * @param second second operand
	 */
	public void multiply(double first, double second) {
		this.result = first * second;
	}
}