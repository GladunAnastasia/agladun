package ru.job4j.collections.pro.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс MySetArray.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 16.05.2017
 */
public class MySetArray<T> implements SimpleSet<T> {
    /**
     * Массив.
     */
    private Object[] objects;
    /**
     * Изначальный размер массива.
     */
    private int size = 10;
    /**
     * Номер позиции.
     */
    private int position;

    /**
     * Конструктор.
     */
    public MySetArray() {
        objects = new Object[size];
    }

    /**
     * Добавляет элемент во множество.
     *
     * @param value - добавляемое значение.
     * @return - возвращает true или false.
     */
    public boolean add(T value) {
        for (int i = 0; i < position; i++) {
            if (objects[i].equals(value)) {
                objects[i] = value;
                return false;
            }
        }
        if (position == size) {
            increaseSizeArray();
        }
        objects[position++] = value;
        return true;
    }

    /**
     * @return - возвращает итератор.
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Позиция массива.
             */
            private int index;

            /**
             * Проверяет существование следующего элемента массива.
             *
             * @return - возвращает true или false.
             */
            @Override
            public boolean hasNext() {
                return index < position;
            }

            /**
             * @return - возвращает следующий элемент массива.
             */
            @Override
            public T next() {
                return (T) objects[index++];
            }
        };
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
