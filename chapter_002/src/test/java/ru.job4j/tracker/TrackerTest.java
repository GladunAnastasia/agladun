package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс TrackerTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 05.04.2017
 */
public class TrackerTest {
    /**
     * MethodTest.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUpdateItemThenTrackerHasUpdateItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescriptionNEW", 123456L);
        tracker.add(item);
        tracker.update(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 123L);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById("test2"), is(item2));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenFindAllThenReturnTrackerWithoutNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(null);
        tracker.add(null);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(null);
        assertThat(tracker.findAll(), is(new Item[]{item1, item2, item3}));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 123L);
        Item item3 = new Item("test3", "testDescription1", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("testDescription1"), is(new Item[]{item1, item3}));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenDeleteItemThenTrackerWithoutThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 1231L);
        Item item2 = new Item("test2", "testDescription2", 1232L);
        Item item3 = new Item("test3", "testDescription3", 1233L);
        Item item4 = new Item("test4", "testDescription4", 1233L);
        Item item5 = new Item("test5", "testDescription5", 1233L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item2);
        tracker.delete(item4);
        assertThat(tracker.getAll(), is(new Item[]{item1, item3, item5, null, null}));
    }
}
