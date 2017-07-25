package ru.job4j.collections.pro.map;

import java.util.Calendar;

/**
 * Класс User.
 *
 * @author Анастасия Гладун
 * @since 24.07.2017
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
