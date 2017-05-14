package ru.job4j.collections.pro.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс MyArrayList.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 * @param <T> - параметр.
 */
public class MyArrayList<T> implements SimpleContainer<T> {
    /**
     * Размер массива.
     */
    private int size;
    /**
     * Массив.
     */
    private Object[] objects;
    /**
     * Позиция массива.
     */
    private int position;

    /**
     * @return - возвращает итератор.
     */
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Добавляет элемент в список.
     *
     * @param value - добавляемый элемент.
     */
    public void add(T value) {
        if (position == size) {
            increaseSizeArray();
        }
        objects[position++] = value;
    }

    /**
     * Возвращает элемент из списка по индексу.
     *
     * @param index - индекс.
     * @return - возвращает элемент.
     */
    public T get(int index) {
        if (position > index && index >= 0) {
            return (T) objects[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Класс MyIterator.
     */
    public class MyIterator implements Iterator<T> {
        /**
         * Индекс.
         */
        private int index;

        /**
         * проверяет существование следующего элемента списка..
         *
         * @return - возвращает true или false.
         */
        public boolean hasNext() {
            return index < position;
        }

        /**
         * @return - возвращает следующий элемент списка.
         */
        public T next() {
            return hasNext() ? (T) objects[index++] : null;
        }
    }

    /**
     * Увеличивает размер массива.
     */
    private void increaseSizeArray() {
        size = (size * 3) / 2 + 1;
        objects = Arrays.copyOf(objects, size);
    }

    /**
     * @return - возвращает длину списка.
     */
    public int getLength() {
        return position;
    }
}
