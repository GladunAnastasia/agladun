package ru.job4j.collections.pro.list;

/**
 * Интерфейс SimpleContainer.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 * @param <T> - параметр.
 */
public interface SimpleContainer<T> extends Iterable<T> {
    /**
     * Добавляет элемент в список.
     * @param value - добавляемый элемент.
     */
    void add(T value);

    /**
     * Возвращает элемент из списка по индексу.
     * @param index - индекс.
     * @return - возвращает элемент.
     */
    T get(int index);
}
