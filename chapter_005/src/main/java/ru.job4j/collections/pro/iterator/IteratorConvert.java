package ru.job4j.collections.pro.iterator;

import java.util.Iterator;

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
        if (itInteger.hasNext()) {
            return true;
        } else {
            if (itIterator.hasNext()) {
                itInteger = itIterator.next();
                return hasNext();
            }
        }
        return false;
    }

    /**
     * @return - возвращает следующий элемент массива.
     */
    @Override
    public Integer next() {
        if (itInteger.hasNext()) {
            return itInteger.next();
        } else {
            if (itIterator.hasNext()) {
                itInteger = itIterator.next();
                return next();
            }
        }
        return null;
    }

    /**
     * Конвертирует итератор итераторов, которвые содержат данные типа Integer, в один итератор со всеми данными типа Integer.
     *
     * @param it - Ковертирует итератор итераторов, которвые содержат данные типа Integer.
     * @return - возвращает итератор, содержащий данные типа Integer.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        itIterator = it;
        if (itIterator.hasNext()) {
            itInteger = itIterator.next();
        }
        return this;
    }


}
