package ru.job4j.collections.light;

import java.util.ArrayList;
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
        int index = 0;
        int[][] array = new int[rows][rows];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < rows; j++) {
                if (index == list.size()) {
                    break;
                }
                array[i][j] = list.get(index++);
            }
        }
        return array;
    }
}
