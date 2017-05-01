package ru.job4j.collections.light;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ConvertListTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 01.05.2017
 */
public class ConvertListTest {
    /**
     * Test method.
     */
    @Test
    public void whenTwoDimensionalArrayToListThenList() {
        ConvertList con = new ConvertList();
        int[][] array = {{1, 2}, {2, 5, 4}, {8, 9}};
        List<Integer> list = Arrays.asList(1, 2, 2, 5, 4, 8, 9);
        assertThat(con.toList(array), is(list));
    }

    /**
     * Test method.
     */
    @Test
    public void whenListToTwoDimensionalArrayThenTwoDimensionalArray() {
        ConvertList con = new ConvertList();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}, {21, 22, 23, 24}, {25, 0, 0, 0}};
        assertThat(con.toArray(list, 7), is(array));
    }


}