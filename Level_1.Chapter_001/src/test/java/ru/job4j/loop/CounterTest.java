package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CounterTest.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 23.03.2017
 */
public class CounterTest {
	/**
	 * Method.
	 */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
		int sum = counter.add(1, 10);
		assertThat(sum, is(30));
    }
}