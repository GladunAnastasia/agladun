package ru.job4j.collections.pro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MyQueueTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 */
public class MyQueueTest {
    /**
     * Test method.
     */
    @Test
    public void whenDeleteThenSizeZero() {
        MyQueue<String> queue = new MyQueue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        queue.push("5");
        queue.push("6");
        queue.push("7");
        queue.push("8");
        assertThat(queue.poll(), is("1"));
        assertThat(queue.poll(), is("2"));
        assertThat(queue.poll(), is("3"));
        assertThat(queue.poll(), is("4"));
        assertThat(queue.poll(), is("5"));
        assertThat(queue.poll(), is("6"));
        assertThat(queue.poll(), is("7"));
        assertThat(queue.poll(), is("8"));
        assertThat(queue.getLength(), is(0));
    }

}