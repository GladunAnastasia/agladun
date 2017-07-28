package ru.job4j.collections.pro.set;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Класс MyMap.
 *
 * @param <K> - параметр для ключа.
 * @param <V> - параметр для значения.
 */
public class MyMap<K, V> implements SimpleMap<K, V> {
    /**
     * Массив для пар ключ-значение.
     */
    private Entry<?, ?>[] table;
    /**
     * Максимальный размер массива.
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /**
     * Количество добавленных пар в карту.
     */
    private int count;
    /**
     * Коэффициент загрузки.
     */
    private float loadFactor;
    /**
     * Порог, при превышении которого увеличивается размер массива table.
     */
    private int threshold;

    /**
     * Конструктор.
     */
    public MyMap() {
        int initialCapacity = 11;
        loadFactor = 0.75f;
        threshold = (int) Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = new Entry<?, ?>[initialCapacity];
    }

    /**
     * @return - возвращает количество пар в карте.
     */
    public int size() {
        return count;
    }

    /**
     * Добавляет пару ключ-значение в карту.
     *
     * @param key   - ключ.
     * @param value - значение.
     * @return - возвращает null, если пара добавлена в карту. Возвращает замененное значение пары, если ее ключ и ключ новой добавляемой пары совпали.
     */
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<K, V> entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, index);
        return null;
    }

    /**
     * Увеличивает емкость массива table.
     */
    protected void rehash() {
        int oldCapacity = table.length;
        Entry<?, ?>[] oldMap = table;

        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<?, ?>[] newMap = new Entry<?, ?>[newCapacity];

        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap;

        for (int i = oldCapacity; i-- > 0; ) {
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old;
                old = old.next;
                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = (Entry<K, V>) newMap[index];
                newMap[index] = e;
            }
        }
    }

    /**
     * Добавляет новую пару в table.
     *
     * @param hash  - хэш-код ключа.
     * @param key   - ключ.
     * @param value - значение.
     * @param index - индекс массива table.
     */
    private void addEntry(int hash, K key, V value, int index) {
        Entry<?, ?> tab[] = table;
        if (count >= threshold) {
            rehash();

            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }
        Entry<K, V> e = (Entry<K, V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }

    /**
     * @return - возвращает итератор карты.
     */
    public Iterator<K> iterator() {
        return new IteratorMap();
    }

    /**
     * Класс IteratorMap.
     */
    public class IteratorMap implements Iterator<K> {
        /**
         * Индекс.
         */
        private int inx = 0;
        /**
         * Пара ключ-значение.
         */
        Entry<K, V> k;
        /**
         * Длина массива table.
         */
        private int length = table.length;

        /**
         * @return - возвращает следующую пару ключ-значение.
         */
        public K next() {
            if (k == null) {
                for (int i = 0; i < length; i++) {
                    if (table[i] != null) {
                        k = (Entry<K, V>) table[i];
                        return k.getKey();
                    }
                }
            } else {
                if (k.next != null) {
                    for (Entry<K, V> t = k; t != null; t = t.next) {
                        if (t.getKey().hashCode() == k.getKey().hashCode() && t.getKey().equals(k.getKey())) {
                            k = k.next;
                            return k.getKey();
                        }
                    }
                }
                int hash = k.getKey().hashCode();
                int index = (hash & 0x7FFFFFFF) % table.length;
                for (int i = index + 1; i < length; i++) {
                    if (table[i] == null) {
                        continue;
                    }
                    k = (Entry<K, V>) table[i];
                    return k.getKey();
                }
            }
            throw new NullPointerException();
        }

        /**
         * @return - true или false в зависимости от того, есть ли еще в карте пары.
         */
        public boolean hasNext() {
            if (k == null) {
                boolean u = count > 0;
                if (u) {
                    inx++;
                }
                return u;
            } else {
                if (k.next != null) {
                    inx++;
                    return true;
                }
                return inx++ < count;
            }
        }
    }

    /**
     * Класс Entry.
     *
     * @param <K> - параметр для ключа.
     * @param <V> - параметр для значения.
     */
    private static class Entry<K, V> implements Map.Entry<K, V> {
        /**
         * Хэш-код ключа.
         */
        final int hash;
        /**
         * Ключ.
         */
        final K key;
        /**
         * Значение.
         */
        V value;
        /**
         * Следующая пара в связном списке, который находится в ячейке массива table.
         */
        Entry<K, V> next;

        /**
         * Конструктор.
         *
         * @param hash  - хэш-код ключа.
         * @param key   - ключ.
         * @param value - значение.
         * @param next  - следующая пара в связном списке.
         */
        protected Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * @return - возвращает ключ пары.
         */
        public K getKey() {
            return key;
        }

        /**
         * @return - возвращает значение пары.
         */
        public V getValue() {
            return value;
        }

        /**
         * Устанавливает новое значение для пары.
         *
         * @param value - новое значение.
         * @return - возвращает старое замененное значение пары.
         */
        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        /**
         * Переопределенный метод equals.
         *
         * @param o - объект.
         * @return - возвращает true или false.
         */
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        /**
         * Переопределенный метод hashCode.
         *
         * @return - возвращает хэш-код.
         */
        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

    }
}
