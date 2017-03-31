package ru.job4j.profession;

/**
 * Класс Person.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Person {
    /**
     * Имя человека.
     */
    private String name;

    /**
     * Конструктор Person.
     *
     * @param name - имя человека
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Метод getName.
     *
     * @return - возвращает имя человека
     */
    public String getName() {
        return name;
    }
}
