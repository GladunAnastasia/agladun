package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Maximum value Test.
 *
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.4
 * @since 23.03.2017
 */
public class MaxTest {
	/**
	 * MaxTest.
	 */
	 @Test
	public void whenMaxTwelveMoreThreeThenTwelve() {
		Max max = new Max();
		int result = max.max(12, 3);
		assertThat(12, is(result));
	}
	/**
	 * MaxTest.
	 */
	@Test
	public void whenMaxThreeLessTwelveThenTwelve() {
		Max max = new Max();
		int result = max.max(3, 12);
		assertThat(12, is(result));
	}
}