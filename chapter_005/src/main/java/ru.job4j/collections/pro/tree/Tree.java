package ru.job4j.collections.pro.Tree;

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
                if (nextNode == null) {
                    nextNode = nodeTree;
                } else {
                    nextNode = recursionForIterator(nodeTree, nextNode.value);
                }
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
        Iterator<Node<T>> iter = node.children.iterator();
        if (node.value.equals(parent)) {
            return iter.hasNext() ? iter.next() : null;
        }
        for (; iter.hasNext(); ) {
            Node<T> o = iter.next();
            if (compare(o, parent) == 0) {
                Iterator<Node<T>> itit = o.children.iterator();
                if (itit.hasNext()) {
                    return itit.next();
                } else if (iter.hasNext()) {
                    return iter.next();
                }
                founded = true;
                return null;
            }
            Node<T> l = recursionForIterator(o, parent);
            if (l != null) {
                return l;
            } else {
                if (founded && iter.hasNext()) {
                    founded = false;
                    return iter.next();
                }
            }
        }
        return null;
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
        if (nodeTree != null) {
            Node<T> y = recursion(nodeTree, parent);
            if (y != null) {
                Node<T> newCh = new Node<T>();
                newCh.value = child;
                y.children.add(newCh);
                count++;
                return true;
            }
            return false;

        } else {
            nodeTree = new Node<>();
            nodeTree.value = parent;
            Node<T> branchChild = new Node<>();
            branchChild.value = child;
            nodeTree.children.add(branchChild);
            count = 2;
            return true;
        }
    }

    /**
     * Метод выполняет поиск элемент в дереве по его значению.
     *
     * @param node   - первый элемент дерева.
     * @param parent - значение элемента, к которому будет добавлен дочерний элемент.
     * @return - возвращает элемент дерева, к которому будет добавлен дочерний элемент.
     */
    public Node<T> recursion(Node<T> node, T parent) {
        if (node.value.equals(parent)) {
            return node;
        }
        Iterator<Node<T>> iter = node.children.iterator();
        for (; iter.hasNext(); ) {
            Node<T> o = iter.next();
            if (compare(o, parent) == 0) {
                return o;
            }
            Node<T> l = recursion(o, parent);
            if (l != null) {
                return l;
            }
        }
        return null;
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
     * @param <T> - параметр.
     */
    class Node<T> {
        List<Node<T>> children = new LinkedList<>();
        T value;
    }

}
