package ru.job4j.tracker;

/**
 * Интерфейс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public interface Input {
    /**
     * @param question - вопрос.
     * @return - зависит от реализации.
     */
    String ask(String question);
}
