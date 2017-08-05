package ru.job4j.collections.pro.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TreeIsBinaryTest.
 *
 * @author Анастасия Гладун
 * @since 03.08.2017
 */
public class TreeIsBinaryTest {
    /**
     * Тестовый метод.
     */
    @Test
    public void checkTreeIsBinary() {
        Tree<String> tree1 = new Tree<>();
        tree1.add("Родитель", "Сын1");
        tree1.add("Родитель", "Сын2");
        tree1.add("Сын2", "Сын2.1");
        tree1.add("Сын2", "Сын2.2");
        tree1.add("Сын2", "Сын2.3");
        tree1.add("Сын1", "Сын1.1");
        tree1.add("Сын1", "Сын1.2");
        tree1.add("Сын1", "Сын1.3");
        tree1.add("Сын2.1", "Сын2.1.1");
        tree1.add("Сын2.1", "Сын2.1.2");
        tree1.add("Сын2.1", "Сын2.1.3");
        tree1.add("Сын2.2", "Сын2.2.1");
        tree1.add("Сын2.2", "Сын2.2.2");
        tree1.add("Сын2.2", "Сын2.2.3");
        tree1.add("Сын2.3", "Сын2.3.1");
        tree1.add("Сын2.3", "Сын2.3.2");
        tree1.add("Сын2.3", "Сын2.3.3");
        boolean check1 = tree1.isBinary();

        Tree<String> tree2 = new Tree<>();
        tree2.add("Родитель", "Сын1");
        tree2.add("Родитель", "Сын2");
        tree2.add("Сын2", "Сын2.1");
        tree2.add("Сын2", "Сын2.2");
        tree2.add("Сын1", "Сын1.1");
        tree2.add("Сын1", "Сын1.2");
        tree2.add("Сын2.1", "Сын2.1.1");
        tree2.add("Сын2.1", "Сын2.1.2");
        tree2.add("Сын2.2", "Сын2.2.1");
        tree2.add("Сын2.2", "Сын2.2.2");
        boolean check2 = tree2.isBinary();

        Tree<String> tree3 = new Tree<>();
        tree3.add("Родитель", "Сын1");
        tree3.add("Родитель", "Сын2");
        tree3.add("Сын2", "Сын2.1");
        tree3.add("Сын2", "Сын2.2");
        tree3.add("Сын1", "Сын1.1");
        tree3.add("Сын1", "Сын1.2");
        tree3.add("Сын2.1", "Сын2.1.1");
        tree3.add("Сын2.1", "Сын2.1.2");
        tree3.add("Сын2.2", "Сын2.2.1");
        tree3.add("Сын2.2", "Сын2.2.2");
        tree3.add("Сын2.2", "Сын2.2.3");
        boolean check3 = tree3.isBinary();

        assertThat(false, is(check1));
        assertThat(true, is(check2));
        assertThat(false, is(check3));
    }
}