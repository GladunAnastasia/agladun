package ru.job4j.collections.pro.set;

/**
 * Интерфейс SimpleMap.
 *
 * @param <K> - параметр для ключа.
 * @param <V> - параметр для значения.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 26.07.2017
 */
public interface SimpleMap<K, V> extends Iterable<K> {
    /**
     * Добавляет пару ключ-значение в карту.
     *
     * @param key   - ключ.
     * @param value - значение.
     * @return - возвращает замененное значение или null, если в карту добавлена новая пара.
     */
    V put(K key, V value);
}
