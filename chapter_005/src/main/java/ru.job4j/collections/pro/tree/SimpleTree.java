package ru.job4j.collections.pro.tree;

/**
 * Интерфейс SimpleTree.
 *
 * @author Анастасия Гладун
 * @since 29.07.2017
 */
public interface SimpleTree<T extends Comparable<T>> extends Iterable<T> {
    /**
     * @param parent - элемент дерева, которому добавляем дочерний элемент.
     * @param child  - добавляемый дочерний элемент.
     * @return - возвращает true, если элемент добавлен в дерево, в противном случае возвращает false.
     */
    boolean add(T parent, T child);

    /**
     * @return - возвращает true, если дерево является бинарным, в противном случае возвращает false.
     */
    boolean isBinary();
}
