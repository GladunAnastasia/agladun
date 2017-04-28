package ru.job4j.tracker;

/**
 * Класс ConsoleInput.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 28.04.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * Описание действия.
     */
    private String name;

    /**
     * Конструктор.
     *
     * @param name - описание действия.
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * @return - возвращает описание действия.
     */
    public String info() {
        return name;
    }
}
