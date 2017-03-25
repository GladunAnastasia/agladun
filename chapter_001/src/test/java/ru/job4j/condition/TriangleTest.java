package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.core.Is.is;
/**
 * Triangle Test.
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.5
 * @since 23.03.2017
 */
public class TriangleTest {
	/**
	 * Method zero.
	 */
	@Test
	public void whenAreaLineThenZero() {
		Point a = new Point(3, 1);
		Point b = new Point(2, 1);
		Point c = new Point(1, 1);
		Triangle triangle = new Triangle(a, b, c);
		double n = triangle.area();
		assertThat(n, is(0.00));
	}
	/**
	 * Method double number.
	 */
	@Test
	public void whenAreaTriangleThenDoubleNumber() {
		Point a = new Point(4, 1);
		Point b = new Point(2, 6);
		Point c = new Point(1, 1);
		Triangle triangle = new Triangle(a, b, c);
		double n = triangle.area();
		assertThat(n, closeTo(7.50, 0.01));
	}
}