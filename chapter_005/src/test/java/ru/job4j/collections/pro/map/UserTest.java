package ru.job4j.collections.pro.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс UserTest.
 *
 * @author Анастасия Гладун
 * @since 24.07.2017
 */
public class UserTest {
    /**
     * Method.
     * Выводит на печать два объекта-значения. Потому что хоть ключи этих объектов-значений и содержат одинаковые данные,
     * но при этом у них разные хэш-кода, то есть не переопределен метод hashCode, а также метод equals для класса User.
     */
    @Test
    public void whenDifferentHashCodeAndEqualsThenTwoObjects() {
        User1 first = new User1("Egor", 3, new GregorianCalendar(1967, 03, 06));
        User1 second = new User1("Egor", 3, new GregorianCalendar(1967, 03, 06));
        Map<User1, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }

    /**
     * Method.
     * Выводит на печать два объекта-значения. Потому что хоть ключи этих объектов-значений и содержат одинаковые данные и
     * хэш-кода объектов-ключей равны, но не выполнено еще одно условие условие - не переопределен метод equals для класса User.
     */
    @Test
    public void whenDifferentEqualsThenTwoObjects() {
        User2 first = new User2("Egor", 3, new GregorianCalendar(1967, 03, 06));
        User2 second = new User2("Egor", 3, new GregorianCalendar(1967, 03, 06));
        Map<User2, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }

    /**
     * Method.
     * Выводит на печать два объекта-значения. Потому что хоть ключи этих объектов-значений и содержат одинаковые данные и
     * метод equals переопределен, но не выполнено еще одно условие - не переопределен метод hashCode для класса User.
     */
    @Test
    public void whenDifferentHashCodeThenTwoObjects() {
        User3 first = new User3("Egor", 3, new GregorianCalendar(1967, 03, 06));
        User3 second = new User3("Egor", 3, new GregorianCalendar(1967, 03, 06));
        Map<User3, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }

    /**
     * Method.
     * Выводит на печать один объект-значение. Потому что для класса User переопределены и метод hashCode, и метод equals.
     */
    @Test
    public void whenTheSameEqualsAndHashCodeThenTwoObjects() {
        User4 first = new User4("Egor", 3, new GregorianCalendar(1967, 03, 06));
        User4 second = new User4("Egor", 3, new GregorianCalendar(1967, 03, 06));
        Map<User4, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }
}