package ru.job4j.collections.pro.iterator;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class IteratorArrayTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 29.04.2017
 */
public class IteratorArrayTest {
    /**
     * Test method.
     */
    @Test
    public void whenGetNextCallThenShouldPointerForward() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4, 5}, {6}});

        int result = (Integer) it.next();
        result = (Integer) it.next();
        result = (Integer) it.next();
        result = (Integer) it.next();

        assertThat(result, is(4));

        result = (Integer) it.next();
        result = (Integer) it.next();

        assertThat(result, is(6));
    }
    /**
     * Test method.
     */
    @Test
    public void whenCheckNextPositionThenShouldTurnConstantValue() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4, 5}, {6}});
        it.hasNext();
        boolean result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        result = it.hasNext();
        assertThat(result, is(false));
    }
}