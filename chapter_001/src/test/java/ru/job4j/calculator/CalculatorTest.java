package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Anastasia Gladun (netmislei@mail.ru)
 */
public class CalculatorTest {
	/**
	 * Method Add Test.
	 */
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	 * Method Div Test.
	 */
	@Test
	public void whenDivNineDivThreeThenThree() {
		Calculator calc = new Calculator();
		calc.div(9D, 3D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}
	/**
	 * Method Substruct Test.
	 */
	@Test
	public void whenSubstructNinePlusThreeThenSix() {
		Calculator calc = new Calculator();
		calc.substruct(9D, 3D);
		double result = calc.getResult();
		double expected = 6D;
		assertThat(result, is(expected));
	}
	/**
	 * Method Multiply Test.
	 */
	@Test
	public void whenMultiplyNinePlusThreeThenTwentySeven() {
		Calculator calc = new Calculator();
		calc.multiply(9D, 3D);
		double result = calc.getResult();
		double expected = 27D;
		assertThat(result, is(expected));
	}
}

