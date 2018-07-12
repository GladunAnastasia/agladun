package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class BubbleSortTest.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class BubbleSortTest {
	/**
	 * Method.
	 */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
		BubbleSort bubbleSort = new BubbleSort();
		array = bubbleSort.sort(array);
		assertThat(array, is(new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8}));
    }
}