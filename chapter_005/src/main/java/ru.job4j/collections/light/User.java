package ru.job4j.collections.light;

/**
 * Класс User.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 02.05.2017
 */
public class User {
    /**
     *
     */
    private static int position;
    /**
     * id.
     */
    private int id;
    /**
     * Имя.
     */
    private String name;
    /**
     * Город.
     */
    private String city;

    /**
     * Конструктор.
     * @param name - имя.
     * @param city - город.
     */
    public User(String name, String city) {
        this.id = ++position;
        this.name = name;
        this.city = city;
    }

    /**
     * @return - возвращает id.
     */
    public int getId() {
        return id;
    }
}
