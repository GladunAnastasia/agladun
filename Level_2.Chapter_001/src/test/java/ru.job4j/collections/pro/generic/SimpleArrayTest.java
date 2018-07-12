package ru.job4j.collections.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Класс SimpleArray.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 07.05.2017
 */
public class SimpleArrayTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddPositionThenArrayWithThisPosition() {
        SimpleArray<String> simple = new SimpleArray<>();
        for (int i = 0; i < 26; i++) {
            simple.add(String.valueOf(i));
        }
        assertThat(simple.get(25), is("25"));
        assertThat(simple.getLength(), is(26));
    }

    /**
     * Test method.
     */
    @Test
    public void whenInsertPositionThenArrayWithThisPosition() {
        SimpleArray<String> simple = new SimpleArray<>();
        for (int i = 0; i < 10; i++) {
            simple.add(String.valueOf(i));
        }
        simple.add(4, "200");
        for (int i = 11; i < 25; i++) {
            simple.add(String.valueOf(i));
        }
        simple.add(23, "600");
        simple.add(26, "700");
        assertThat(simple.get(3), is("3"));
        assertThat(simple.get(4), is("200"));
        assertThat(simple.get(5), is("4"));
        assertThat(simple.get(22), is("22"));
        assertThat(simple.get(23), is("600"));
        assertThat(simple.get(24), is("23"));
        assertThat(simple.get(25), is("24"));
        assertThat(simple.get(26), is("700"));
        assertThat(simple.getLength(), is(27));
    }

    /**
     * Test method.
     */
    @Test
    public void whenDeletePositionThenArrayWithoutThisPosition() {
        SimpleArray<String> simple = new SimpleArray<>();
        for (int i = 0; i < 25; i++) {
            simple.add(String.valueOf(i));
        }
        simple.delete(22);
        simple.delete(23);
        assertThat(simple.get(19), is("19"));
        assertThat(simple.get(20), is("20"));
        assertThat(simple.get(21), is("21"));
        assertThat(simple.get(22), is("23"));
        assertThat(simple.getLength(), is(23));
    }

    /**
     * Test method.
     */
    @Test
    public void whenUpdatePositionThenArrayWithUpdatedPosition() {
        SimpleArray<String> simple = new SimpleArray<>();
        for (int i = 0; i < 25; i++) {
            simple.add(String.valueOf(i));
        }
        simple.update(15, "300");
        assertThat(simple.get(14), is("14"));
        assertThat(simple.get(15), is("300"));
        assertThat(simple.get(16), is("16"));
        assertThat(simple.getLength(), is(25));
    }
}