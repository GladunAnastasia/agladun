package ru.job4j.tracker;

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
    private int[] range = {0, 1, 2, 3, 4, 5, 6};
    /**
     * Флаг.
     */
    private boolean flag;
    /**
     * Список действий.
     */
    private String[] list = new String[6];

    /**
     * Конструктор StubInput.
     *
     * @param list - список действий.
     */
    public StubInput(String[] list) {
        this.list[0] = list[0];
        this.list[1] = list[1];
        this.list[2] = list[2];
        this.list[3] = list[3];
        this.list[4] = list[4];
        this.list[5] = list[5];
    }

    /**
     * Метод выводит вопрос и считывает строку с консоли.
     *
     * @param question - вопрос.
     * @param range - диапозон действий.
     * @return - считывает строку с консоли.
     */
    public int ask(String question, int[] range) {
        System.out.println(question);
        if ("Select: ".equals(question) && !flag) {
            flag = true;
            System.out.println(list[0]);
            return Integer.valueOf(list[0]);
        } else if ("Select: ".equals(question)) {
            System.out.println(list[5]);
            return Integer.valueOf(list[5]);
        }
        return Integer.valueOf(list[5]);
    }

    /**
     * @param question - вопрос.
     * @return - возвращает номер позиции.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        if ("Input item's name: ".equals(question) || "Correct name: ".equals(question)) {
            System.out.println(list[2]);
            return list[2];
        } else if ("Input description: ".equals(question) || "Correct description: ".equals(question)) {
            System.out.println(list[3]);
            return list[3];
        } else if ("Input date: ".equals(question) || "Correct date: ".equals(question)) {
            System.out.println(list[4]);
            return list[4];
        } else if ("Input ID: ".equals(question)) {
            System.out.println(list[1]);
            return list[1];
        }
        return "";
    }
}
