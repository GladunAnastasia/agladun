package ru.job4j.collections.light;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс UserConvertTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 02.05.2017
 */
public class UserConvertTest {
    /**
     * Test method.
     */
    @Test
    public void whenListToHashMap() {
        UserConvert ucon = new UserConvert();
        List<User> list = new ArrayList<User>();
        User userOne = new User("Max", "Moscow");
        User userTwo = new User("Denis", "Ulan-Ude");
        User userThree = new User("Dmitrii", "Omsk");
        list.add(userOne);
        list.add(userTwo);
        list.add(userThree);
        HashMap<Integer, User> map = ucon.process(list);
        HashMap<Integer, User> mapCheck = new HashMap<Integer, User>();
        mapCheck.put(1, userOne);
        mapCheck.put(2, userTwo);
        mapCheck.put(3, userThree);
        assertThat(map, is(mapCheck));
    }

}