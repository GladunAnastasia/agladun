package ru.job4j.tracker;

/**
 * Класс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 27.04.2017
 */
public interface UserAction {
    /**
     * @return - возвращает номер действия.
     */
    int key();

    /**
     * Выполняет действие.
     *
     * @param input   - переменная интерфейса Input.
     * @param tracker - переменная класса Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * @return описание действия.
     */
    String info();
}
