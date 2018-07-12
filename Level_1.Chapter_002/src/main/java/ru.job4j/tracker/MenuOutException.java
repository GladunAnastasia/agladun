package ru.job4j.tracker;

/**
 * Класс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 27.04.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     * Исключение выхода за границы меню.
     * @param message - сообщение ошибки.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
