package ru.job4j.collections.pro.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TreeTest.
 *
 * @author Анастасия Гладун
 * @since 29.07.2017
 */
public class TreeTest {
    /**
     * Тестовый метод.
     */
    @Test
    public void whenAddItemThenGetTrueOrFalse() {
        Tree<String> tr = new Tree<>();
        boolean j1 = tr.add("Родитель", "Сын1");
        tr.add("Родитель", "Сын2");
        tr.add("Родитель", "Сын3");
        tr.add("Сын2", "Сын2.1");
        tr.add("Сын2", "Сын2.2");
        tr.add("Сын2", "Сын2.3");
        tr.add("Сын1", "Сын1.1");
        tr.add("Сын1", "Сын1.2");
        tr.add("Сын1", "Сын1.3");
        tr.add("Сын3", "Сын3.1");
        tr.add("Сын3", "Сын3.2");
        boolean j2 = tr.add("Сын3", "Сын3.3");
        tr.add("Сын2.1", "Сын2.1.1");
        tr.add("Сын2.1", "Сын2.1.2");
        tr.add("Сын2.1", "Сын2.1.3");
        tr.add("Сын2.2", "Сын2.2.1");
        tr.add("Сын2.2", "Сын2.2.2");
        tr.add("Сын2.2", "Сын2.2.3");
        tr.add("Сын2.3", "Сын2.3.1");
        tr.add("Сын2.3", "Сын2.3.2");
        tr.add("Сын2.3", "Сын2.3.3");
        boolean j3 = tr.add("", "1");
        assertThat(j1, is(true));
        assertThat(j2, is(true));
        assertThat(j3, is(false));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void CheckIterator() {
        Tree<String> tr = new Tree<>();
        tr.add("Родитель", "Сын1");
        tr.add("Родитель", "Сын2");
        tr.add("Родитель", "Сын3");
        tr.add("Сын2", "Сын2.1");
        tr.add("Сын2", "Сын2.2");
        tr.add("Сын2", "Сын2.3");
        tr.add("Сын1", "Сын1.1");
        tr.add("Сын1", "Сын1.2");
        tr.add("Сын1", "Сын1.3");
        tr.add("Сын3", "Сын3.1");
        tr.add("Сын3", "Сын3.2");
        tr.add("Сын3", "Сын3.3");
        tr.add("Сын2.1", "Сын2.1.1");
        tr.add("Сын2.1", "Сын2.1.2");
        tr.add("Сын2.1", "Сын2.1.3");
        tr.add("Сын2.2", "Сын2.2.1");
        tr.add("Сын2.2", "Сын2.2.2");
        tr.add("Сын2.2", "Сын2.2.3");
        tr.add("Сын2.3", "Сын2.3.1");
        tr.add("Сын2.3", "Сын2.3.2");
        tr.add("Сын2.3", "Сын2.3.3");
        Iterator<String> it = tr.iterator();
        String s1 = it.next();
        boolean t1 = it.hasNext();
        boolean t2 = it.hasNext();
        String s2 = it.next();
        boolean t3 = it.hasNext();
        String s3 = it.next();
        boolean t4 = it.hasNext();
        String s4 = it.next();
        boolean t5 = it.hasNext();
        String s5 = it.next();
        boolean t6 = it.hasNext();
        boolean t7 = it.hasNext();
        boolean t8 = it.hasNext();
        String s6 = it.next();
        String s7 = it.next();
        String s8 = it.next();
        boolean t9 = it.hasNext();
        String s9 = it.next();
        boolean t10 = it.hasNext();
        String s10 = it.next();
        boolean t11 = it.hasNext();
        String s11 = it.next();
        boolean t12 = it.hasNext();
        String s12 = it.next();
        boolean t13 = it.hasNext();
        String s13 = it.next();
        boolean t14 = it.hasNext();
        String s14 = it.next();
        boolean t15 = it.hasNext();
        String s15 = it.next();
        boolean t16 = it.hasNext();
        String s16 = it.next();
        boolean t17 = it.hasNext();
        String s17 = it.next();
        boolean t18 = it.hasNext();
        String s18 = it.next();
        boolean t19 = it.hasNext();
        String s19 = it.next();
        boolean t20 = it.hasNext();
        String s20 = it.next();
        boolean t21 = it.hasNext();
        String s21 = it.next();
        boolean t22 = it.hasNext();
        String s22 = it.next();
        boolean t23 = it.hasNext();
        assertThat(true, is(t7));
        assertThat(false, is(t23));
        assertThat(s1, is("Родитель"));
        assertThat(s2, is("Сын1"));
        assertThat(s3, is("Сын1.1"));
        assertThat(s4, is("Сын1.2"));
        assertThat(s5, is("Сын1.3"));
        assertThat(s6, is("Сын2"));
        assertThat(s7, is("Сын2.1"));
        assertThat(s8, is("Сын2.1.1"));
        assertThat(s9, is("Сын2.1.2"));
        assertThat(s10, is("Сын2.1.3"));
        assertThat(s11, is("Сын2.2"));
        assertThat(s12, is("Сын2.2.1"));
        assertThat(s13, is("Сын2.2.2"));
        assertThat(s14, is("Сын2.2.3"));
        assertThat(s15, is("Сын2.3"));
        assertThat(s16, is("Сын2.3.1"));
        assertThat(s17, is("Сын2.3.2"));
        assertThat(s18, is("Сын2.3.3"));
        assertThat(s19, is("Сын3"));
        assertThat(s20, is("Сын3.1"));
        assertThat(s21, is("Сын3.2"));
        assertThat(s22, is("Сын3.3"));
    }
}
