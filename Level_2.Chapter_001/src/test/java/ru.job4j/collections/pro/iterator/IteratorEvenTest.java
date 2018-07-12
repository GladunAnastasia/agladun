package ru.job4j.collections.pro.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class IteratorEvenTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 29.04.2017
 */
public class IteratorEvenTest {
    /**
     * Test method.
     */
    @Test
    public void whenGetNextCallThenShouldPointerForward() {
        IteratorEven it = new IteratorEven(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 9, 10});

        int result = (Integer) it.next();
        assertThat(result, is(2));

        result = (Integer) it.next();
        assertThat(result, is(4));

        result = (Integer) it.next();
        assertThat(result, is(6));

        result = (Integer) it.next();
        assertThat(result, is(10));
    }

    /**
     * Test method.
     */
    @Test
    public void whenCheckNextPositionThenShouldTurnConstantValue() {
        IteratorEven it = new IteratorEven(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 9, 10});
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
        assertThat(result, is(false));
    }
}