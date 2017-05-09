package ru.job4j.collections.pro.generic;

import java.util.Arrays;

/**
 * Класс SimpleArray.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 07.05.2017
 */
public class SimpleArray<T> {
    /**
     * Массив.
     */
    private Object[] objects;
    /**
     * Номер позиции.
     */
    private int position;
    /**
     * Размер массива.
     */
    private int size;

    /**
     * Конструктор с параметром.
     *
     * @param size - размер массива.
     */
    public SimpleArray(int size) {
        objects = new Object[size];
    }

    /**
     * Конструктор.
     */
    public SimpleArray() {
        size = 10;
        objects = new Object[size];
    }

    /**
     * Добавление в конец списка.
     *
     * @param value - добавляемое значение.
     */
    public void add(T value) {
        if (position == size) {
            increaseSizeArray();
        }
        objects[position++] = value;
    }

    /**
     * Добавление в середину списка.
     *
     * @param index - индекс списка.
     * @param value - значение списка.
     */
    public void add(int index, T value) {
        if (position >= index && index >= 0) {
            if (position == size) {
                increaseSizeArray();
            }
            System.arraycopy(objects, index, objects, index + 1, position - index);
            position++;
            objects[index] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * @param index - индекс списка.
     * @return - возвращает элемент списка по индексу.
     */
    public T get(int index) {
        if (position > index && index >= 0) {
            return (T) objects[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Изменяет данные списка.
     *
     * @param index - индекс списка.
     * @param value - значение списка.
     */
    public void update(int index, T value) {
        if (position > index && index >= 0) {
            objects[index] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Удаляет элемент списка по индексу.
     *
     * @param index - индекс списка.
     */
    public void delete(int index) {
        if (position > index && index >= 0) {
            objects[index] = null;
            System.arraycopy(objects, index + 1, objects, index, position - index - 1);
            objects[position - 1] = null;
            position--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
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
