package ru.job4j.collections.pro.iterator;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class IteratorPrimeTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 29.04.2017
 */
public class IteratorPrimeTest {
    /**
     * Test method.
     */
    @Test
    public void whenGetNextCallThenShouldPointerForward() {
        IteratorPrime it = new IteratorPrime(new int[]{1, 2, 20, 4, 5, 6, 7, 7, 9, 10});

        int result = (Integer) it.next();
        assertThat(result, is(1));

        result = (Integer) it.next();
        assertThat(result, is(2));

        result = (Integer) it.next();
        assertThat(result, is(5));

        result = (Integer) it.next();
        assertThat(result, is(7));

        result = (Integer) it.next();
        assertThat(result, is(7));
    }

    /**
     * Test method.
     */
    @Test
    public void whenCheckNextPositionThenShouldTurnConstantValue() {
        IteratorPrime it = new IteratorPrime(new int[]{1, 2, 20, 4, 5, 6, 7, 7, 9, 10});
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