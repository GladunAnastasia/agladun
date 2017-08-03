package ru.job4j.collections.pro.Tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TreeTest.
 *
 * @author Анастасия Гладун
 * @since 29.07.2017
 */
public class TreeTest {
    @Test
    public void whenThen() {
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
        boolean j = tr.add("", "1");
//        tr.add("Сын1.1", "Сын1.1.1");
//        tr.add("Сын1.1", "Сын1.1.2");
//        tr.add("Сын1.1", "Сын1.1.3");
//        tr.add("Сын1.2", "Сын1.2.1");
//        tr.add("Сын1.2", "Сын1.2.2");
//        tr.add("Сын1.2", "Сын1.2.3");
//        tr.add("Сын1.3", "Сын1.3.1");
//        tr.add("Сын1.3", "Сын1.3.2");
//        tr.add("Сын1.3", "Сын1.3.3");
//        tr.add("Сын3.1", "Сын3.1.1");
//        tr.add("Сын3.1", "Сын3.1.2");
//        tr.add("Сын3.1", "Сын3.1.3");
//        tr.add("Сын3.2", "Сын3.2.1");
//        tr.add("Сын3.2", "Сын3.2.2");
//        tr.add("Сын3.2", "Сын3.2.3");
//        tr.add("Сын3.3", "Сын3.3.1");
//        tr.add("Сын3.3", "Сын3.3.2");
//        tr.add("Сын3.3", "Сын3.3.3");
//        tr.add("Сын3.1.2", "Сын3.1.2.3");
        Iterator<String> it = tr.iterator();
        boolean t1 = it.hasNext();
        String s1 = it.next();
        boolean t2 = it.hasNext();
        String s2 = it.next();
        boolean t3 = it.hasNext();
        String s3 = it.next();
        boolean t4 = it.hasNext();
        String s4 = it.next();
        boolean t5 = it.hasNext();
        String s5 = it.next();
        boolean t6 = it.hasNext();
        String s6 = it.next();
        boolean t7 = it.hasNext();
        String s7 = it.next();
        boolean t8 = it.hasNext();
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
    }
}
