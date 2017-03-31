package ru.job4j.profession;

/**
 * Класс Education.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Education {
    /**
     * Наименование образования.
     */
    private String name;

    /**
     * Конструктор Education.
     *
     * @param name - наименование образования.
     */
    public Education(String name) {
        this.name = name;
    }

    /**
     * Геттер getName.
     *
     * @return - возвращает наименование образования.
     */
    public String getName() {
        return this.name;
    }
}
