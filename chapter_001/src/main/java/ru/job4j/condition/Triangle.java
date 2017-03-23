package ru.job4j.condition;
/**
 * Triangle.
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.5
 * @since 23.03.2017
 */
public class Triangle {
	/**
	 * Point a.
	 */
	private Point a;
	/**
	 * Point b.
	 */
	private Point b;
	/**
	 * Point c.
	 */
	private Point c;
	/**
	 * Constructor.
	 * @param a - Point a
	 * @param b - Point b
	 * @param c - Point c
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * Square.
	 * @return - Square
	 */
	public double area() {
		double s1 = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
		double s2 = Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2));
		double s3 = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2));
		double p = (s1 + s2 + s3) / 2;
		return (s1 + s2 == s3 || s1 + s3 == s2 || s2 + s3 == s1) ? 0.00 : Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
	}
}