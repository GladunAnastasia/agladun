package ru.job4j.collections.pro.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MySetArrayTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 16.05.2017
 */
public class MySetArrayTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddThenSetWithoutDuplicates() {
        MySetArray<Integer> mySet = new MySetArray<>();
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        mySet.add(1);
        mySet.add(3);
        mySet.add(1);
        assertThat(mySet.getLength(), is(3));
    }

    /**
     * Test method.
     */
    @Test
    public void whenIteratorNextThenItWorks() {
        MySetArray<Integer> mySet = new MySetArray<>();
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        mySet.add(1);
        mySet.add(3);
        mySet.add(1);
        Iterator<Integer> it = mySet.iterator();
        it.hasNext();
        it.hasNext();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        assertThat(mySet.getLength(), is(3));
    }

}