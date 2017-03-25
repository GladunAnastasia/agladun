package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class RotateArrayTest.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class RotateArrayTest {
	/**
	 * Method.
	 */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
		int[][] array = {{1, 2}, {3, 4}};
		array = rotateArray.rotate(array);
		assertThat(array, is(new int[][]{{3, 1}, {4, 2}}));
    }
	/**
	 * Method.
	 */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
		int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		array = rotateArray.rotate(array);
		assertThat(array, is(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}));
    }
	/**
	 * Method.
	 */
	@Test
    public void whenRotateSevenRowSevenColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] array = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
		array = rotateArray.rotate(array);
		assertThat(array, is(new int[][]{{43, 36, 29, 22, 15, 8, 1}, {44, 37, 30, 23, 16, 9, 2}, {45, 38, 31, 24, 17, 10, 3}, {46, 39, 32, 25, 18, 11, 4}, {47, 40, 33, 26, 19, 12, 5}, {48, 41, 34, 27, 20, 13, 6}, {49, 42, 35, 28, 21, 14, 7}}));
    }
}