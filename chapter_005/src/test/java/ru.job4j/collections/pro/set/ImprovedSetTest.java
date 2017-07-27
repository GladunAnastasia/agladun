package ru.job4j.collections.pro.set;

import org.junit.Test;

import java.util.Date;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ImprovedSetTest.
 *
 * @author Anastasia Gladun
 * @since 24.07.2017
 */
public class ImprovedSetTest {
    /**
     * Test method.
     */
    @Test
    public void whenCompareTwoMethodsThenFirstIsFaster() {
        Date date1 = new Date();
        ImprovedSet<Integer> set = new ImprovedSet<>();
        Iterator it = set.iterator();

        for (int i = 0; i < 100000; i++) {
            set.add(i);
        }
        for (int i = 0; i < 80000; i++) {
            set.add(i);
        }
        Date date2 = new Date();
        MySetLinkedList<Integer> listSet = new MySetLinkedList<>();
        for (int i = 0; i < 100000; i++) {
            listSet.add(i);
        }
        for (int i = 0; i < 80000; i++) {
            listSet.add(i);
        }
        Date date3 = new Date();
        System.out.println((date2.getTime() - date1.getTime()) + " меньше, чем " + (date3.getTime() - date2.getTime()));
        assertThat(set.size(), is(listSet.getLength()));
    }
}
