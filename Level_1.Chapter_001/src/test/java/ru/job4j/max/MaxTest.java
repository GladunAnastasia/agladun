package ru.job4j.max;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Maximum value Test.
 *
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.4
 * @since 23.03.2017
 */
public class MaxTest {
	/**
	 * max.
	 */
	private Max max = new Max();
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxTwelveMoreThreeThenTwelve() {
		int result = max.max(12, 3);
		assertThat(result, is(12));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxThreeLessTwelveThenTwelve() {
		int result = max.max(3, 12);
		assertThat(result, is(12));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxOneTwoThreeThenTwelve() {
		int result = max.max(1, 2, 3);
		assertThat(result, is(3));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxTwoOneThreeThenTwelve() {
		int result = max.max(2, 1, 3);
		assertThat(result, is(3));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxTwoThreeOneThenTwelve() {
		int result = max.max(2, 3, 1);
		assertThat(result, is(3));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxOneThreeTwoThenTwelve() {
		int result = max.max(1, 3, 2);
		assertThat(result, is(3));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxThreeOneTwoThenTwelve() {
		int result = max.max(3, 1, 2);
		assertThat(result, is(3));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxThreeTwoOneThenTwelve() {
		int result = max.max(3, 2, 1);
		assertThat(result, is(3));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxThreeThreeThreeThenTwelve() {
		int result = max.max(3, 3, 3);
		assertThat(result, is(3));
	}
}