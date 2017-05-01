package ru.job4j.collections.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorPrime.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 29.04.2017
 */
public class IteratorPrime implements Iterator {
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
    public IteratorPrime(int[] values) {
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
            if (values[indexSecond] % 2 == 0 && values[indexSecond] != 2) {
                indexSecond++;
                continue;
            }
            int sum = 0;
            for (int j = 3; j <= values[indexSecond] / 2; j++) {
                if (values[indexSecond] % j == 0) {
                    sum++;
                    break;
                }
            }
            if (sum == 0 && values[indexSecond] > 0) {
                indexSecond++;
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
            if (values[index] % 2 == 0 && values[index] != 2) {
                index++;
                continue;
            }
            int sum = 0;
            for (int j = 3; j <= values[index] / 2; j++) {
                if (values[index] % j == 0) {
                    sum++;
                    break;
                }
            }
            if (sum == 0 && values[index] > 0) {
                value = (Integer) values[index];
                index++;
                break;
            }
            index++;
        }
        return (Integer) value;
    }


}