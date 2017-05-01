package ru.job4j.collections.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorArray.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 29.04.2017
 */
public class IteratorArray implements Iterator {
    /**
     * Массив.
     */
    private int[][] values;
    /**
     * Позиция массива.
     */
    private int index1 = 0;
    /**
     * Позиция массива.
     */
    private int index2 = 0;


    /**
     * Конструктор.
     *
     * @param values - массив.
     */
    public IteratorArray(int[][] values) {
        this.values = values;
    }

    /**
     * проверяет существование следующего элемента массива.
     *
     * @return - возвращает true или false.
     */
    @Override
    public boolean hasNext() {
        return !(index1 == (values.length - 1) && index2 == (values[index1].length - 1));
    }

    /**
     * @return - возвращает следующий элемент массива.
     */
    @Override
    public Object next() {
        Object value = values[index1][index2];
        if (index2 == values[index1].length - 1) {
            index2 = 0;
            index1++;
        } else {
            index2++;
        }
        return value;
    }
}
