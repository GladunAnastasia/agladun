package ru.job4j.collections.pro.iterator;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Класс IteratorConvert.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 06.05.2017
 */
public class IteratorConvert implements Iterator<Integer> {
    /**
     * Итератор итераторов.
     */
    private Iterator<Iterator<Integer>> itIterator;
    /**
     * Итератор.
     */
    private Iterator<Integer> itInteger;

    /**
     * Проверяет существование следующего элемента итератора или списка.
     *
     * @return - возвращает true или false.
     */
    @Override
    public boolean hasNext() {
        return itInteger.hasNext();
    }

    /**
     * @return - возвращает следующий элемент массива.
     */
    @Override
    public Integer next() {
        return itInteger.hasNext() ? itInteger.next() : null;
    }

    /**
     * Ковертирует итератор итераторов, которвые содержат данные типа Integer, в один итератор со всеми данными типа Integer.
     *
     * @param it - Ковертирует итератор итераторов, которвые содержат данные типа Integer.
     * @return - возвращает итератор, содержащий данные типа Integer.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        itIterator = it;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (itIterator.hasNext()) {
            itInteger = itIterator.next();
            while (hasNext()) {
                list.add(next());
            }
        }
        itInteger = list.iterator();
        return this;
    }


}
