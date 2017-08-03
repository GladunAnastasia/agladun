package ru.job4j.collections.pro.Tree;

/**
 * Интерфейс SimpleTree.
 *
 * @author Анастасия Гладун
 * @since 29.07.2017
 */
public interface SimpleTree<T extends Comparable<T>> extends Iterable<T> {
    boolean add(T parent, T child);
}
