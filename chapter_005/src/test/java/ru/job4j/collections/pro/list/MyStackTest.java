package ru.job4j.collections.pro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MyStackTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 */
public class MyStackTest {
    /**
     * Test method.
     */
    @Test
    public void whenThen() {
        MyStack<String> stack = new MyStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        assertThat(stack.pop(), is("8"));
        assertThat(stack.pop(), is("7"));
        assertThat(stack.pop(), is("6"));
        assertThat(stack.pop(), is("5"));
        assertThat(stack.pop(), is("4"));
        assertThat(stack.pop(), is("3"));
        assertThat(stack.pop(), is("2"));
        assertThat(stack.pop(), is("1"));
        assertThat(stack.getLength(), is(0));
    }

}