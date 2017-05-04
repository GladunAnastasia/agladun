package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

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
        Item item = new Item("1", "test1", 123L, "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUpdateItemThenTrackerHasUpdateItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", 123456L, "testDescriptionNEW");
        tracker.add(item);
        tracker.update(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1", "test1", 123L, "testDescription1");
        Item item2 = new Item("2", "test2", 123L, "testDescription2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById("2"), is(item2));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenFindAllThenReturnTrackerWithoutNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1", "test1", 123L, "testDescription");
        Item item2 = new Item("2", "test2", 123L, "testDescription");
        Item item3 = new Item("3", "test3", 123L, "testDescription");
        tracker.add(item1);
        tracker.add(null);
        tracker.add(null);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(null);
        assertThat(tracker.findAll(), is(Arrays.asList(new Item[]{item1, item2, item3})));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1", "test1", 123L, "testDescription1");
        Item item2 = new Item("2", "test2", 123L, "testDescription2");
        Item item3 = new Item("3", "test1", 123L, "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("test1"), is(Arrays.asList(new Item[]{item1, item3})));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenDeleteItemThenTrackerWithoutThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1", "test1", 1231L, "testDescription1");
        Item item2 = new Item("2", "test2", 1232L, "testDescription2");
        Item item3 = new Item("3", "test3", 1233L, "testDescription3");
        Item item4 = new Item("4", "test4", 1233L, "testDescription4");
        Item item5 = new Item("5", "test5", 1233L, "testDescription5");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item2);
        tracker.delete(item4);
        assertThat(tracker.getAll(), is(Arrays.asList(new Item[]{item1, item3, item5})));
    }
}
