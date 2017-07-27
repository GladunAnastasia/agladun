package ru.job4j.collections.pro.map;

import java.util.Iterator;

/**
 * Класс MyMap.
 *
 * @author Анастасия Гладун.
 * @since 27.07.2017
 */
public class MyMap<K, V> implements SimpleMap<K, V>{
    private int count;
    /**
     * @param key
     * @param value
     * @return
     */
    public boolean insert(K key, V value) {
        return true;
    }
    public int size() {
        return count;
    }
    /**
     * @param key
     * @return
     */
    public V get(K key){
        return (V) new Object();
    }

    /**
     * @param key
     * @return
     */
    public boolean delete(K key) {
        return true;
    }
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            private int index = 0;
            private K array[];
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public K next() {
                return array[index++];
            }
        };
    }
}
