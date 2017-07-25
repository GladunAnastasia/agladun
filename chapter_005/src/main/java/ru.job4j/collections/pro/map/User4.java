package ru.job4j.collections.pro.map;

import java.util.Calendar;

/**
 * Класс User4.
 *
 * @author Анастасия Гладун
 * @since 24.07.2017
 */
public class User4 {
    private String name;
    private int children;
    private Calendar birthday;

    public User4(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        User4 user = (User4) o;
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (children != user.children) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}

