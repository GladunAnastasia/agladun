package ru.job4j.collections.pro.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Класс ReferenceBook.
 *
 * @param <K> - K.
 * @param <V> - V.
 * @author Анастасия Гладун.
 * @since 27.07.2017
 */
public class ReferenceBook<K, V> implements SimpleMap<K, V> {
    /**
     * Количество добавленных пар в карту.
     */
    private int count;
    /**
     * Массив для пар ключ-значение.
     */
    private Entry<?, ?>[] table;
    /**
     * Порог, при превышении которого увеличивается размер массива table.
     */
    private int threshold;
    /**
     * Коэффициент загрузки.
     */
    private float loadFactor;
    /**
     * Максимальный размер массива.
     */
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Конструктор.
     */
    public ReferenceBook() {
        int initialCapacity = 11;
        table = new Entry<?, ?>[initialCapacity];
        loadFactor = 0.75f;
        threshold = Math.min((int) (initialCapacity * loadFactor), MAX_ARRAY_SIZE);
    }

    /**
     * @param key   - ключ.
     * @param value - значение.
     * @return - возвращает true, если пара добавлена. Возвращает false, если не добавилась.
     */
    public V insert(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<K, V> entry = (Entry<K, V>) tab[index];

//        if (entry == null) { // игнорируем ситуации с коллизиями.
//            addEntry(hash, key, value, index);
//            return true; // если двум парам выпадает один и тот же индекс в table, то новая добавляемая пара не записывается и возвращается false.
//        }
//        return false;
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
     * Увеличивает емкость массива table.
     */
    public void rehash() {
        int oldCapacity = table.length;
        Entry<?, ?>[] oldMap = table;
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE) {
                return;
            }
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<?, ?>[] newMap = new Entry<?, ?>[newCapacity];
        threshold = Math.min((int) (newCapacity * loadFactor), MAX_ARRAY_SIZE);
        table = newMap;
        for (int i = oldCapacity; i-- > 0; ) {
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old;
                old = old.next; // если в старой карте в данной ячейке больше, чем одна запись, то old.next != null и цикл повторится еще раз.
                int index = (e.getKey().hashCode() & 0x7FFFFFFF) % newCapacity; // рассчитываем новый индекс.
                e.next = (Entry<K, V>) newMap[index]; // если в новой карте в данной ячейке есть другая запись, то она сохраняется в поле e.next.
                newMap[index] = e; // а первое место в связном списке данной ячейки занимает e.
            }
        }
    }

    /**
     * @return - возвращает количество пар в карте.
     */
    public int size() {
        return count;
    }

    /**
     * @param key - ключ.
     * @return - возвращает значение по ключу. Если пара с таким ключом не находится, возвращается null.
     */
    public V get(K key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.getKey().equals(key)) {
                return (V) e.getValue();
            }
        }
        return null;
    }

    /**
     * @param key - ключ.
     * @return - возвращает true, если пара удалилась. Возвращает false, если не удалилась(не нашлась пара по ключу).
     */
    public boolean delete(K key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if ((e.hash == hash) && e.getKey().equals(key)) {
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                count--;
                e.value = null;
                return true;
            }
        }
        return false;
    }

    /**
     * @return - возвращает итератор.
     */
    public Iterator<K> iterator() {

        return new Iterator<K>() {
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

                ;
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
            if (value == null) {
                throw new NullPointerException();
            }
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
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return (key == null ? e.getKey() == null : key.equals(e.getKey())) && (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        /**
         * Переопределенный метод hashCode.
         *
         * @return - возвращает хэш-код.
         */
        @Override
        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }
    }
}
