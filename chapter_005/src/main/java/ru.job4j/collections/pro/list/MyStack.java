package ru.job4j.collections.pro.list;


/**
 * Класс MyStack.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 */
public class MyStack<T> {
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
    public MyStack() {
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
    public T pop() {
        T e = list.get(size - 1);
        list.remove(size - 1);
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
