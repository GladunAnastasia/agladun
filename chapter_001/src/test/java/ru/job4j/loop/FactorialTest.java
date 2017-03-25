package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class FactorialTest.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 23.03.2017
 */
 public class FactorialTest {
	 /**
	 * Method.
	 */
	@Test
	 public void whenEightThenFactorialEight() {
		 Factorial f = new Factorial();
		 int n = f.calc(8);
		 assertThat(n, is(40320));
	 }
 }