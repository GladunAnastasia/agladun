package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * The point on the function Test.
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.5
 * @since 23.03.2017
 */
public class PointTest {
		/**
		 * Method is when true.
		 */
		@Test
		public void whenIsPointFiveAndSeventeenLiesOnFunctionThenTrue() {
			Point point = new Point(5, 17);
			boolean b = point.is(3, 2);
			assertThat(b, is(true));
		}
		/**
		 * Method is when false.
		 */
		@Test
		public void whenIsPointSixAndSeventeenDoesntLieOnFunctionThenFalse() {
			Point point = new Point(6, 17);
			boolean b = point.is(3, 2);
			assertThat(b, is(false));
		}
}