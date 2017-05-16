package ru.job4j.collections.pro.set;

/**
 * Класс SimpleSet.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 16.05.2017
 */
public interface SimpleSet<T> extends Iterable<T> {
    /**
     * Добавляет элемент во множество.
     *
     * @param value - добавляемое значение.
     * @return - возвращает true или false.
     */
    boolean add(T value);
}
