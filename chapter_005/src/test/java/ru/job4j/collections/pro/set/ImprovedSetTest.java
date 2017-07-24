package ru.job4j.collections.pro.set;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ImprovedTest.
 *
 * @author Anastasia Gladun
 * @since 24.07.2017
 */
public class ImprovedSetTest {
    /**
     * Test method.
     */
    @Test
    public void whenCompareTwoMethodsThen() {
        Date date1 = new Date();
        ImprovedSet<Integer> set = new ImprovedSet<>();
        for (int i = 0; i < 100000; i++) {
            set.add(i);
        }
        for (int i = 0; i < 80000; i++) {
            set.add(i);
        }
        Date date2 = new Date();
        //System.out.println(date2.getTime() - date1.getTime());
        Date date3 = new Date();
        MySetLinkedList<Integer> listSet = new MySetLinkedList<>();
        for (int i = 0; i < 100000; i++) {
            listSet.add(i);
        }
        for (int i = 0; i < 80000; i++) {
            set.add(i);
        }
        Date date4 = new Date();
        System.out.println((date4.getTime() - date3.getTime()) + " больше, чем " + (date2.getTime() - date1.getTime()));
        assertThat(set.size(), is(listSet.getLength()));
    }
}
