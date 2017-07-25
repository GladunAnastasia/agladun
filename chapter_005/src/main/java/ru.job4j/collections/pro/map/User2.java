package ru.job4j.collections.pro.map;

<<<<<<< HEAD
import java.util.Calendar;

/**
 * Класс User2.
 *
 * @author Анастасия Гладун
 * @since 24.07.2017
 */
public class User2 {
    private String name;
    private int children;
    private Calendar birthday;

    public User2(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
=======
/**
 * Created by Netmislei on 25.07.2017.
 */
public class User2 {
>>>>>>> 58d5c0b... new
}
