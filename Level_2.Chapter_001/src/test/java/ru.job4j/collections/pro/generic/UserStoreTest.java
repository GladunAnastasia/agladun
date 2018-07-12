package ru.job4j.collections.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс UserStoreTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 09.05.2017
 */
public class UserStoreTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddNewUser() {
        UserStore user = new UserStore();
        user.add(new User());
        user.add(new User());
        user.add(new User());
        user.add(new User());
        assertThat(user.getArray().getLength(), is(4));
    }

    /**
     * Test method.
     */
    @Test
    public void whenDeleteUser() {
        UserStore user = new UserStore();
        user.add(new User());
        user.add(new User());
        user.add(new User());
        user.add(new User());
        user.delete("2");
        assertThat(user.getArray().get(0).getId(), is("1"));
        assertThat(user.getArray().get(1).getId(), is("3"));
        assertThat(user.getArray().getLength(), is(3));
    }

    /**
     * Test method.
     */
    @Test
    public void whenUpdateUser() {
        UserStore user = new UserStore();
        User us = new User();
        user.add(new User());
        user.add(us);
        user.add(new User());
        user.add(new User());
        user.update("2", new User());
        assertThat(user.getArray().get(1).getId(), is("2"));
        assertThat(!us.equals(user.getArray().get(1)), is(true));
        assertThat(user.getArray().getLength(), is(4));
    }
}