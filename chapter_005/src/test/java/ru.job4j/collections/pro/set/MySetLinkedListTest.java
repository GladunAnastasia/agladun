package ru.job4j.collections.pro.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MySetLinkedList.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 16.05.2017
 */
public class MySetLinkedListTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddThenSetWithoutDuplicates() {
        MySetLinkedList<Integer> list = new MySetLinkedList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(1);
        list.add(4);
        assertThat(list.getLength(), is(4));
    }
}