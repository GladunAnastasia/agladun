package ru.job4j.collections.light;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class TestAddDelete.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 30.05.2017
 */
public class TestAddDelete {
    /**
     * @param collection - коллекция строк.
     * @param line       - строка.
     * @param amount     - количество строк.
     * @return - возвращает время, потраченное на добавления строк.
     */
    public long add(Collection<String> collection, String line, int amount) {
        Date dateBegin = new Date();
        for (int i = 0; i < amount; i++) {
            collection.add(line + i);
        }
        Date dateEnd = new Date();
        return dateEnd.getTime() - dateBegin.getTime();
    }

    /**
     * @param collection - коллекций строк.
     * @param amount     - количество строк.
     * @return - возвращает время, потраченное на удаление строк.
     */
    public long delete(Collection<String> collection, int amount) {
        Date dateBegin = new Date();
        Iterator<String> it = collection.iterator();
        while (it.hasNext() && amount-- != 0) {
            it.next();
            it.remove();
        }
        Date dateEnd = new Date();
        return dateEnd.getTime() - dateBegin.getTime();
    }
    /**
     * Main.
     *
     * @param args - параметры.
     */
    public static void main(String[] args) {
        TestAddDelete test = new TestAddDelete();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeList = new TreeSet<>();
        System.out.println("Add element to an ArrayList: " + test.add(arrayList, "String for test - ", 100000));
        System.out.println("Add element to an LinkedList: " + test.add(linkedList, "String for test - ", 100000));
        System.out.println("Add element to an TreeSet: " + test.add(treeList, "String for test - ", 100000));
        System.out.println();
        System.out.println("Delete element to an ArrayList: " + test.delete(arrayList, 100000));
        System.out.println("Delete element to an LinkedList: " + test.delete(linkedList, 100000));
        System.out.println("Delete element to an TreeSet: " + test.delete(treeList, 100000));
    }
}
