package ru.job4j.collections.pro.map;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ReferenceBookTest.
 *
 * @author Анастасия Гладун
 * @since 27.07.2017
 */
public class ReferenceBookTest {
    /**
     * Карта.
     */
    private static ReferenceBook<String, String> map;

    /**
     * Method.
     */
    @BeforeClass
    public static void method() {
        map = new ReferenceBook<>();
        map.insert("\0A", "a1");
        map.insert("\0\0A", "a2");
        map.insert("A", "a3");
        map.insert("B", "b");
        map.insert("C", "c");
        map.insert("D", "d");
        map.insert("E", "e");
        map.insert("F", "f");
        map.insert("G", "g");
        map.insert("H", "h");
        map.insert("I", "i");
        map.insert("P", "p");
    }

    /**
     * Method.
     */
    @Test
    public void wnehGetThenGetRightValue() {
        String p1 = map.get("1");
        String p2 = map.get("\0A");
        String p3 = map.get("A");
        String p4 = map.get("P");
        assertThat(null, is(p1));
        assertThat("a1", is(p2));
        assertThat("a3", is(p3));
        assertThat("p", is(p4));
    }

    /**
     * Method.
     */
    @Test
    public void whenDeleteThenGetRightResult() {
        boolean i1 = map.delete("1");
        boolean i2 = map.delete("F");
        boolean i3 = map.delete("\0A");
        assertThat(false, is(i1));
        assertThat(true, is(i2));
        assertThat(true, is(i3));
    }

    /**
     * Method.
     */
    @Test
    public void CheckIterator() {
        Iterator it = map.iterator();
        ArrayList<String> list = new ArrayList<>();
        for (; it.hasNext(); ) {
            list.add((String) it.next());
        }
        assertThat(list, is(Arrays.asList(new String[]{"E", "F", "G", "H", "I", "P", "\0A", "\0\0A", "A", "B", "C", "D"})));
        assertThat(it.hasNext(), is(false));
    }
}
