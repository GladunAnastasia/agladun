package ru.job4j.collections.pro.set;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Класс ImprovedSet.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 24.07.2017
 */
public class ImprovedSet<T> implements SimpleSet<T> {
    /**
     * Коллекция Map.
     */
    private HashMap<T, Object> map;
    /**
     * Объект для записи значений в map.
     */
    private static final Object PRESENT = new Object();

    /**
     * Конструктор.
     */
    public ImprovedSet() {
        map = new HashMap<T, Object>();
    }

    /**
     * Добавляет значение во множество.
     *
     * @param value - добавляемое значение в map. Ключ.
     * @return - true или false в зависимости от того
     */
    public boolean add(T value) {
        return map.put(value, PRESENT) == null;
    }

    /**
     * @return - возвращает итератор.
     */
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    /**
     * @return - возвращает размер множества.
     */
    public int size() {
        return map.size();
    }

}
