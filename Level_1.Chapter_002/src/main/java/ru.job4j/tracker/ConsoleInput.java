package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * Класс ConsoleInput.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class ConsoleInput implements Input {
    /**
     * Флаг для поиска в диапозоне действий.
     */
    private boolean exist;
    /**
     * Объект для считывания данных с консоли.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводит вопрос и считывает строку с консоли.
     *
     * @param question - вопрос.
     * @return - считывает строку с консоли.
     */
    public String ask(String question) {
        System.out.println(question);
        String text = scanner.nextLine();
        return text;
    }

    /**
     * @param question - вопрос.
     * @param range    - диапозон действий.
     * @return - возвращает номер позиции.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            exist = false;
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
