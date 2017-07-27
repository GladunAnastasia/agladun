package ru.job4j.collections.pro.map;

/**
 * Интерфейс SimpleMap.
 *
 * @author Анастасия Гладун.
 * @since 27.07.2017
 */
public interface SimpleMap<K, V> extends Iterable<K> {
    /**
     * @param key
     * @param value
     * @return
     */
    boolean insert(K key, V value);

    /**
     * @param key
     * @return
     */
    V get(K key);

    /**
     * @param key
     * @return
     */
    boolean delete(K key);
}
