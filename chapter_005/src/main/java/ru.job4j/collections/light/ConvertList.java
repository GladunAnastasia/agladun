package ru.job4j.collections.light;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс ConvertList.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 01.05.2017
 */
public class ConvertList {
    /**
     * @param array - двумерный массив.
     * @return - коллекция чисел.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * @param list - коллекция чисел.
     * @param rows - количество строк и колонок.
     * @return - двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int b = list.size() / rows + ((list.size() % rows) > 0 ? 1 : 0);
        int[][] array = new int[rows][b];
        Iterator<Integer> it = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < b; j++) {
                if (!it.hasNext()) {
                    break;
                }
                array[i][j] = it.next();
            }
        }
        return array;
    }

    /**
     * @param list - коллекция массивов чисел.
     * @return - коллекция чисел.
     */
    public List<Integer> convert(List<int[]> list) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int[] array : list) {
            for (Integer number : array) {
                linkedList.add(number);
            }
        }
        return linkedList;
    }
}
