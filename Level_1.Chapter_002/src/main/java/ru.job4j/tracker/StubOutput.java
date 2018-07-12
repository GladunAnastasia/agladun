package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс StubOutput.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 23.04.2017
 */
public class StubOutput implements Input {
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
    public StubOutput(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            this.list.add(list.get(i));
        }
    }

    /**
     * ItemText для теста.
     */
    private String text;

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
        return 0;
    }

    /**
     * Устанавливает значение переменной text.
     *
     * @param text - текст для теста.
     */
    public void setItemText(String text) {
        this.text = text;
    }

    /**
     * @return возвращает текст для текста.
     */
    public String getText() {
        return text;
    }

    /**
     * @param question - вопрос.
     * @return - возвращает номер позиции.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        if ("Input item's name: ".equals(question)) {
            return list.get(2);
        } else if ("Input ID: ".equals(question)) {
            return list.get(1);
        }
        return "";
    }
}
