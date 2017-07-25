package ru.job4j.collections.pro.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс NodeListTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 15.05.2017
 */
public class NodeListTest {
    /**
     * Test method.
     */
    @Test
    public void whenListHasCycleThenTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        assertThat(first.hasCycle(first), is(true));
    }

    /**
     * Test method.
     */
    @Test
    public void whenListHasNotCycleThenFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(null);

        assertThat(first.hasCycle(first), is(false));
    }

}