package ru.job4j.collections.pro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс Tree.
 *
 * @author Анастасия Гладун
 * @since 29.07.2017
 */
public class Tree<T extends Comparable<T>> implements SimpleTree<T> {
    /**
     * Первый элемент дерева.
     */
    private Node<T> nodeTree;
    /**
     * Следующий элемент для итератора.
     */
    private Node<T> nextNode;
    /**
     * Счетчик добавленных в дерево элементов.
     */
    private int count;
    /**
     * Индекс для итератора.
     */
    private int index;
    /**
     * Флаг для рекурсивного метода для итератора. Находится в состоянии true, если нужный элемент в дереве найден.
     * И можно искать относительно этого элемента следующий элемент.
     */
    private boolean founded;

    /**
     * @return
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * @return - возвращает следующий элемент дерева.
             */
            public T next() {
                nextNode = (nextNode == null ? nodeTree : recursionForIterator(nodeTree, nextNode.value));
                if (nextNode != null) {
                    index++;
                    return nextNode.value;
                }
                throw new NumberFormatException();
            }

            /**
             * @return - возвращает true, если в дереве есть следующий элемент, в противном случае возвращает false.
             */
            public boolean hasNext() {
                return index + 1 <= count;
            }
        };
    }

    /**
     * @param node   - первый элемент дерева.
     * @param parent - значение элемента, относительно которого ищем следующий элемент.
     * @return - возвращает следующий элемент.
     */
    public Node<T> recursionForIterator(Node<T> node, T parent) {
        Node<T> y = null;
        Iterator<Node<T>> iter = node.children.iterator();
        if (node.value.equals(parent)) {
            y = iter.hasNext() ? iter.next() : null;
        } else {
            for (; iter.hasNext(); ) {
                Node<T> o = iter.next();
                if (compare(o, parent) == 0) {
                    Iterator<Node<T>> itit = o.children.iterator();
                    if (itit.hasNext()) {
                        y = itit.next();
                        break;
                    } else if (iter.hasNext()) {
                        y = iter.next();
                        break;
                    }
                    founded = true;
                    y = null;
                    break;
                }
                y = recursionForIterator(o, parent);
                if (y != null) {
                    break;
                } else {
                    if (founded && iter.hasNext()) {
                        founded = false;
                        y = iter.next();
                        break;
                    }
                }
            }
        }
        return y;
    }

    /**
     * @return - возвращает размер дерева.
     */
    public int size() {
        return count;
    }

    /**
     * @param parent - элемент дерева, которому добавляем дочерний элемент.
     * @param child  - добавляемый дочерний элемент.
     * @return - возвращает true, если элемент добавлен в дерево, в противном случае возвращает false.
     */
    public boolean add(T parent, T child) {
        Node<T> y;
        if (nodeTree == null) {
            nodeTree = new Node<>();
            nodeTree.value = parent;
            y = new Node<>();
            y.value = child;
            nodeTree.children.add(y);
            count = 2;
        } else {
            y = recursion(nodeTree, parent);
            if (y != null) {
                Node<T> newCh = new Node<T>();
                newCh.value = child;
                y.children.add(newCh);
                count++;
            }
        }
        return y != null;
    }

    /**
     * Метод выполняет поиск элемент в дереве по его значению.
     *
     * @param node   - первый элемент дерева.
     * @param parent - значение элемента, к которому будет добавлен дочерний элемент.
     * @return - возвращает элемент дерева, к которому будет добавлен дочерний элемент.
     */
    public Node<T> recursion(Node<T> node, T parent) {
        Node<T> o = null;
        if (node.value.equals(parent)) {
            o = node;
        } else {
            Iterator<Node<T>> iter = node.children.iterator();
            for (; iter.hasNext(); ) {
                if (compare((o = iter.next()), parent) == 0 || (o = recursion(o, parent)) != null) {
                    break;
                }
            }
        }
        return o;
    }

    /**
     * @param node   - элемент для сравнения.
     * @param parent - значение элемента для сравнения.
     * @return - возвращает 0, если значение элемента node и значение parent равны, в противном случае возвращает false.
     */
    public int compare(Node<T> node, T parent) {
        return (node.value).equals(parent) ? 0 : 1;
    }

    /**
     * @return - возвращает true, если дерево является бинарным, в противном случае возвращает false.
     */
    public boolean isBinary() {
        return recursionForBinary(nodeTree) != null;
    }

    /**
     * Рекурсивный метод для проверки дерева на бинарность.
     *
     * @param node - первый элемент дерева.
     * @return - возвращает null, если дерево не бинарное, в противном случае возвращает объект не равный null.
     */
    public Node<T> recursionForBinary(Node<T> node) {
        Node<T> y = new Node<T>();
        if (node.children.size() > 2) {
            y = null;
        } else {
            Iterator<Node<T>> iter = node.children.iterator();
            for (; iter.hasNext(); ) {
                if ((y = recursionForBinary(iter.next())) == null) {
                    break;
                }
            }
        }
        return y;
    }

    /**
     * @param <T> - параметр.
     */
    class Node<T> {
        List<Node<T>> children = new LinkedList<>();
        T value;
    }

}
