package ru.job4j.collections.pro.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MyLinkedListTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 */
public class MyLinkedListTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddAndGetThenItWorks() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        assertThat(list.get(4), is("5"));
        assertThat(list.getLength(), is(5));
    }

    /**
     * Test method.
     */
    @Test
    public void whenIteratorNextThenListNext() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator<String> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.next(), is("2"));
        it.next();
        it.next();
        assertThat(it.next(), is("5"));
        assertThat(it.hasNext(), is(false));
    }

}