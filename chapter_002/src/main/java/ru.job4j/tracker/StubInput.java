package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс StubInput.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 11.04.2017
 */
public class StubInput implements Input {
    /**
     * Диапозон действий.
     */
    private List<Integer> range = Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5, 6});
    /**
     * Флаг.
     */
    private boolean flag;
    /**
     * Список действий.
     */
    private ArrayList<String> list = new ArrayList<String>();

    /**
     * Конструктор StubInput.
     *
     * @param list - список действий.
     */
    public StubInput(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            this.list.add(list.get(i));
        }
    }

    /**
     * Метод выводит вопрос и считывает строку с консоли.
     *
     * @param question - вопрос.
     * @param range    - диапозон действий.
     * @return - считывает строку с консоли.
     */
    public int ask(String question, List<Integer> range) {
        System.out.println(question);
        if ("Select: ".equals(question) && !flag) {
            flag = true;
            System.out.println(list.get(0));
            return Integer.valueOf(list.get(0));
        } else if ("Select: ".equals(question)) {
            System.out.println(list.get(5));
            return Integer.valueOf(list.get(5));
        }
        return Integer.valueOf(list.get(5));
    }

    /**
     * @param question - вопрос.
     * @return - возвращает номер позиции.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        if ("Input item's name: ".equals(question) || "Correct name: ".equals(question)) {
            System.out.println(list.get(2));
            return list.get(2);
        } else if ("Input description: ".equals(question) || "Correct description: ".equals(question)) {
            System.out.println(list.get(3));
            return list.get(3);
        } else if ("Input date: ".equals(question) || "Correct date: ".equals(question)) {
            System.out.println(list.get(4));
            return list.get(4);
        } else if ("Input ID: ".equals(question)) {
            System.out.println(list.get(1));
            return list.get(1);
        }
        return "";
    }
}
