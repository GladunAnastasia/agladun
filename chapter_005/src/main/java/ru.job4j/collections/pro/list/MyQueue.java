package ru.job4j.collections.pro.list;


/**
 * Класс MyQueue.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 * @param <T> - параметр.
 */
public class MyQueue<T> {
    /**
     * Список.
     */
    private MyLinkedList<T> list;
    /**
     * Размер списка.
     */
    private int size;

    /**
     * Конструктор.
     */
    public MyQueue() {
        list = new MyLinkedList<T>();
    }

    /**
     * Добавляет элемент в стэк.
     *
     * @param value - элемент.
     */
    public void push(T value) {
        list.add(value);
        size++;
    }

    /**
     * Удаляет элемент из стэка.
     *
     * @return - возвращает удаленный элемент.
     */
    public T poll() {
        T e = list.get(0);
        list.remove(0);
        size--;
        return e;
    }

    /**
     * @return - возвращает длину списка.
     */
    public int getLength() {
        return size;
    }
}
