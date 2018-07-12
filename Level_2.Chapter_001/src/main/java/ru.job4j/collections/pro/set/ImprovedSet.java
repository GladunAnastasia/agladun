package ru.job4j.collections.pro.set;


import java.util.*;

/**
 * Класс ImprovedSet.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 24.07.2017
 */
public class ImprovedSet<T> implements SimpleSet<T> {
    /**
     * Карта.
     */
    MyMap<T, Object> myMap = new MyMap<>();

    /**
     * Добавляет значения во множество.
     *
     * @param value - добавляемое значение.
     * @return - true, если элемент добавлен во множество, и false, если не добавлен.
     */
    public boolean add(T value) {
        return myMap.put(value, new Object()) == null;
    }

    /**
     * @return - возвращает итератор.
     */
    public Iterator<T> iterator() {
        return myMap.iterator();
    }

    /**
     * @return - возвращает размер множества.
     */
    public int size() {
        return myMap.size();
    }
}

