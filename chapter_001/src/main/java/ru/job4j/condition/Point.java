package ru.job4j.condition;
/**
 * The point on the function.
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.5
 * @since 23.03.2017
 */
public class Point {
	/**
	 * Abscissa.
	 */
	private int x;
	/**
	 * Ordinate.
	 */
	private int y;
	/**
	 * Constructor.
	 * @param x - abscissa
	 * @param y - ordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * GetX.
	 * @return - abscissa
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * GetY.
	 * @return - ordinate
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * GetY.
	 * @param a - operand
	 * @param b - operand
	 * @return - true or false
	 */
	public boolean is(int a, int b) {
		return y == a * x + b;
	}
	/**
	 * getDistance.
	 * @param b - operand
	 * @return - length
	 */
	public double getDistance(Point b) {
		return Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
  	}
}