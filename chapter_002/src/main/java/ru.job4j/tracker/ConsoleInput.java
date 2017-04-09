package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс ConsoleInput.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class ConsoleInput implements Input {
    /**
     * Объект для считывания данных с консоли.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводит вопрос и считывает строку с консоли.
     * @param question - вопрос.
     * @return - считывает строку с консоли.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
