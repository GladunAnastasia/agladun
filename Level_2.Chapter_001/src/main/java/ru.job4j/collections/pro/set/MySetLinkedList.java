package ru.job4j.collections.pro.set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Класс MySetLinkedList.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 16.05.2017
 */
public class MySetLinkedList<T> implements SimpleSet<T> {
    /**
     * Список.
     */
    private LinkedList<T> list;

    /**
     * Конструктор.
     */
    public MySetLinkedList() {
        list = new LinkedList<>();
    }

    /**
     * Добавляет элемент во множество.
     *
     * @param value - добавляемое значение.
     * @return - возвращает true или false.
     */
    public boolean add(T value) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(value)) {
                return false;
            }
        }
        list.add(value);
        return true;
    }

    /**
     * @return - возвращает итератор.
     */
    public Iterator<T> iterator() {
        return list.iterator();
    }

    /**
     * @return - возвращает длину списка.
     */
    public int getLength() {
        return list.size();
    }
}
