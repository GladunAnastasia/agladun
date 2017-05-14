package ru.job4j.collections.pro.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MyArrayListTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 */
public class MyArrayListTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddAndGetThenItWorks() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        assertThat(list.get(4), is("5"));
        assertThat(list.getLength(), is(13));
    }

    /**
     * Test method.
     */
    @Test
    public void whenIteratorNextThenListNext() {
        MyArrayList<String> list = new MyArrayList<>();
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
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}