package ru.job4j.collections.pro.list;

import java.util.Iterator;

/**
 * Класс MyLinkedList.
 *
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 14.05.2017
 */
public class MyLinkedList<T> implements SimpleContainer<T> {
    /**
     * Первый элемент списка.
     */
    private Node<T> first;
    /**
     * Последний элемент списка.
     */
    private Node<T> last;
    /**
     * Индекс.
     */
    private int index;

    /**
     * @return - возвращает итератор.
     */
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Класс MyIterator.
     */
    public class MyIterator implements Iterator<T> {
        /**
         * Элемент.
         */
        private Node<T> element = first;
        /**
         * Флаг.
         */
        private boolean bool;

        /**
         * проверяет существование следующего элемента списка..
         *
         * @return - возвращает true или false.
         */
        public boolean hasNext() {
            return element.next != null;
        }

        /**
         * @return - возвращает следующий элемент списка.
         */
        public T next() {
            if (bool) {
                element = element.next;
            }
            bool = true;
            return element.getItem();
        }
    }

    /**
     * Добавляет элемент в список.
     *
     * @param value - добавляемый элемент.
     */
    public void add(T value) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, value, null);
        last = newNode;
        index++;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
    }

    /**
     * Возвращает элемент из списка по индексу.
     *
     * @param index - индекс.
     * @return - возвращает элемент.
     */
    public T get(int index) {
        if (index < this.index) {
            Node<T> element = first;
            for (int i = 1; i <= index; i++) {
                element = element.next;
            }
            return element.getItem();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Класс Node.
     *
     * @param <T> - параметр.
     */
    private class Node<T> {
        /**
         * Переменная для текущего элемента.
         */
        private T item;
        /**
         * Переменная для предыдущего элемента.
         */
        private Node<T> prev;
        /**
         * Переменная для следующего элемента.
         */
        private Node<T> next;

        /**
         * Конструктор.
         *
         * @param prev - ссылка на предыдущий элемент.
         * @param item - текущий элемент.
         * @param next - ссылка на следующий элемент.
         */
        private Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        /**
         * @return - возвращает элемент списка.
         */
        public T getItem() {
            return item;
        }
    }

    /**
     * @return - возвращает длину списка.
     */
    public int getLength() {
        return index;
    }

    /**
     * Удаляет элемент из списка по индексу.
     *
     * @param index - индекс.
     */
    public void remove(int index) {
        if (this.index > index && index >= 0) {
            Node<T> element = first;
            for (int i = 1; i <= index; i++) {
                element = element.next;
            }
            if (element.next != null && element.prev != null) {
                element.prev.next = element.next;
                element.next.prev = element.prev;
            } else if (element.next == null && element.prev == null) {
                last = element;
                first = element;
            } else if (element.next == null) {
                element.prev.next = null;
                last = element.prev;
            } else if (element.prev == null) {
                element.next.prev = null;
                first = element.next;
            }
            element = null;
            this.index--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
