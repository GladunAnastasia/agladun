package ru.job4j.collections.pro.map;

/**
 * Интерфейс SimpleMap.
 *
 * @author Анастасия Гладун.
 * @since 27.07.2017
 */
public interface SimpleMap<K, V> extends Iterable<K> {
    /**
     * @param key - ключ.
     * @param value - значение.
     * @return - возвращает true, если новая пара добавлена, возвращает false, если новая пара не добавлена.
     */
    V insert(K key, V value);

    /**
     * @param key - ключ.
     * @return - возвращает значение пары по ключу.
     */
    V get(K key);

    /**
     * @param key - ключ.
     * @return - возвращает true, если пара удалена, возвращает false, если пара не удалена.
     */
    boolean delete(K key);
}
