package ru.job4j.tracker;

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
    private String[] list = new String[6];

    /**
     * Конструктор StubInput.
     *
     * @param list - список действий.
     */
    public StubOutput(String[] list) {
        this.list[0] = list[0];
        this.list[1] = list[1];
        this.list[2] = list[2];
        this.list[3] = list[3];
        this.list[4] = list[4];
        this.list[5] = list[5];
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
            return list[2];
        } else if ("Input ID: ".equals(question)) {
            return list[1];
        }
        return "";
    }
}
