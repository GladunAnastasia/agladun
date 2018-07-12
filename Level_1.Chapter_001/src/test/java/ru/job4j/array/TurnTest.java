package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class TurnTest.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class TurnTest {
	/**
	 * Method.
	 */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
		int[] array = {2, 6, 1, 4};
		Turn turn = new Turn();
		array = turn.back(array);
		assertThat(array, is(new int[] {4, 1, 6, 2}));
    }
	/**
	 * Method.
	 */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
		int[] array = {1, 2, 3, 4, 5};
		Turn turn = new Turn();
		array = turn.back(array);
		assertThat(array, is(new int[] {5, 4, 3, 2, 1}));
    }
}