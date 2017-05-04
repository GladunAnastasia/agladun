package ru.job4j.tracker;

import java.util.List;

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

    /**
     * @param question - вопрос.
     * @param range    - диапозон действий.
     * @return - возвращает номер позиции.
     */
    int ask(String question, List<Integer> range);
}
