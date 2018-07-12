package ru.job4j.collections.pro.list;

/**
 * Класс Node.
 * @param <T> - параметр.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 15.05.2017
 */

public class Node<T> {
    /**
     * Элемент списка.
     */
    private T value;
    /**
     * Следующий элемент списка.
     */
    private Node<T> next;

    /**
     * Конструктор.
     *
     * @param value - элемент списка.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Устанавливает последующий элемент.
     *
     * @param value - последующий элемент.
     */
    public void setNext(Node<T> value) {
        next = value;
    }

    /**
     * Проверяет на замыкание.
     *
     * @param first - первый элемент списка.
     * @return - возвращает true или false.
     */
    public boolean hasCycle(Node first) {
        Node hare = first;
        Node turtle = first.next;
        while (!hare.equals(turtle)) {
            hare = hare.next == null ? null : hare.next;
            turtle = turtle.next == null ? null : turtle.next.next == null ? null : turtle.next.next;
            if (hare == null || turtle == null) {
                return false;
            }
        }
        return true;
    }
}
