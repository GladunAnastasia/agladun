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
    Node<T> nodeTree;
    Node<T> presentNode;
    Node<T> prevNode;

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public T next() {
                if (presentNode == null) {
                    presentNode = nodeTree;
                } else {
                    presentNode = recursionForIterator(nodeTree, presentNode.value);
                }
                if (presentNode != null) {
                    return presentNode.value;
                }
                throw new NumberFormatException();
            }

            public boolean hasNext() {
                if(nodeTree != null && presentNode == null) {
                    return true;
                }

                return recursionForIterator(nodeTree, presentNode.value) != null;
            }
        };
    }

    private boolean founded;
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
//    public Node<T> recursionForIterator(Node<T> node, T parent) {
//        Iterator<Node<T>> iter = node.children.iterator();
//        if (node.value.equals(parent)) {
//            return iter.hasNext() ? iter.next() : null;
//        }
//        for (; iter.hasNext(); ) {
//            Node<T> o = iter.next();
//            if (compare(o, parent) == 0) {
//                Iterator<Node<T>> itit = o.children.iterator();
//                if (itit.hasNext()) {
//                    return itit.next();
//                } else if (iter.hasNext()) {
//                    return iter.next();
//                }
//                founded = true;
//                return null;
//            }
//            Node<T> l = recursionForIterator(o, parent);
//            if (l != null) {
//                return l;
//            } else {
//                if (founded && iter.hasNext()) {
//                    founded = false;
//                    return iter.next();
//                }
//            }
//        }
//        return null;
//    }

    public boolean add(T parent, T child) {
        if (nodeTree != null) {
            Node<T> y = recursion(nodeTree, parent);
            if (y != null) {
                Node<T> newCh = new Node<T>();
                newCh.value = child;
                y.children.add(newCh);
                return true;
            }
            return false;

        } else {
            nodeTree = new Node<>();
            nodeTree.value = parent;
            Node<T> branchChild = new Node<>();
            branchChild.value = child;
            nodeTree.children.add(branchChild);
            return true;
        }

    }


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

    public int compare(Node<T> node, T parent) {
        return (node.value).equals(parent) ? 0 : 1;
    }


    class Node<T> {
        List<Node<T>> children = new LinkedList<>();
        T value;
    }

}
