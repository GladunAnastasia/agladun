package ru.job4j.collections.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorEven.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 29.04.2017
 */
public class IteratorEven implements Iterator {
    /**
     * Массив.
     */
    private int[] values;
    /**
     * Позиция массива.
     */
    private int index = 0;

    /**
     * Конструктор.
     *
     * @param values - массив.
     */
    public IteratorEven(int[] values) {
        this.values = values;
    }

    /**
     * проверяет существование следующего элемента массива.
     *
     * @return - возвращает true или false.
     */
    @Override
    public boolean hasNext() {
        int indexSecond = index;
        for (int i = indexSecond; i < values.length; i++) {
            if (((Integer) (values[i])) % 2 == 0) {
                break;
            }
            indexSecond++;
        }
        return values.length > indexSecond;
    }

    /**
     * @return - возвращает следующий элемент массива.
     */
    @Override
    public Object next() {
        Object value = null;
        for (int i = index; i < values.length; i++) {
            if (((Integer) (values[i])) % 2 == 0) {
                value = values[index];
                index++;
                break;
            }
            index++;
        }
        return (Integer) value;
    }
}
