package ru.job4j.collections.light.comparable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс SortUserTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 02.05.2017
 */
public class SortUserTest {
    /**
     * Test method.
     */
    @Test
    public void whenTreeSetThenSortedSet() {
        SortUser sortUser = new SortUser();
        User userOne = new User("Max", 25);
        User userTwo = new User("Denis", 35);
        User userThree = new User("Alex", 19);
        User userFour = new User("Andrei", 25);
        User userFive = new User("Artem", 17);
        User userSix = new User("Dmitrii", 29);
        ArrayList<User> list = new ArrayList<User>();
        list.add(userOne);
        list.add(userTwo);
        list.add(userThree);
        list.add(userFour);
        list.add(userFive);
        list.add(userSix);
        Set<User> set = sortUser.sort(list);
        Iterator<User> it = set.iterator();
        assertThat(it.next(), is(userFive));
        it.next();
        it.next();
        it.next();
        assertThat(it.next(), is(userSix));
        assertThat(it.next(), is(userTwo));
    }

    /**
     * Test method.
     */
    @Test
    public void whenListWithComparatorThenSortedAgeList() {
        SortUser sortUser = new SortUser();
        User userOne = new User("Max", 25);
        User userTwo = new User("Denis", 35);
        User userThree = new User("Alex", 19);
        User userFour = new User("Andrei", 25);
        User userFive = new User("Artem", 17);
        User userSix = new User("Dmitrii", 29);
        ArrayList<User> list = new ArrayList<User>();
        list.add(userOne);
        list.add(userTwo);
        list.add(userThree);
        list.add(userFour);
        list.add(userFive);
        list.add(userSix);
        List<User> sortedList = sortUser.sortHash(list);
        Iterator<User> it = sortedList.iterator();
        User user1 = it.next();
        User user2 = it.next();
        User user3 = it.next();
        User user4 = it.next();
        assertThat(user1.hashCode() <= user2.hashCode(), is(true));
        assertThat(user2.hashCode() <= user3.hashCode(), is(true));
        assertThat(user3.hashCode() <= user4.hashCode(), is(true));
    }

    /**
     * Test method.
     */
    @Test
    public void whenListWithComparatorThenSortedNameLengthList() {
        SortUser sortUser = new SortUser();
        User userOne = new User("Max", 25);
        User userTwo = new User("Denis", 35);
        User userThree = new User("Alex", 19);
        User userFour = new User("Andrei", 25);
        User userFive = new User("Artem", 17);
        User userSix = new User("Dmitrii", 29);
        ArrayList<User> list = new ArrayList<User>();
        list.add(userOne);
        list.add(userTwo);
        list.add(userThree);
        list.add(userFour);
        list.add(userFive);
        list.add(userSix);
        List<User> sortedList = sortUser.sortLength(list);
        Iterator<User> it = sortedList.iterator();
        assertThat(it.next(), is(userOne));
        assertThat(it.next(), is(userThree));
        it.next();
        it.next();
        assertThat(it.next(), is(userFour));
        assertThat(it.next(), is(userSix));
    }
}