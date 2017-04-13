package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс StubInputTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 11.04.2017
 */
public class StubInputTest {
    /**
     * Переменная, содержащая объект типа Tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * MethodTest.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "", "test name", "desc", "123", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
        tracker.delete(new Item("1"));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenSeeAllItemThenShowAllItem() {
        Item item = new Item("test1", 123456L, "testDescription");
        tracker.add(item);
//        for (Item item1 : tracker.findAll()) {
//            System.out.println("ID: " + item1.getId() + " Name: " + item1.getName() + " Description: " + item1.getDesc());
//        }
        Input input = new StubInput(new String[]{"1", "", "", "", "", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0], is(item));
        tracker.delete(item);
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUserUpdateItemThenTrackerHasUpdateItem() {
        Item item = new Item("test1", 123456L, "testDescription");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test name NEW", "descNEW", "123123", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getId(), is(item.getId()));
        assertThat(tracker.getAll()[0].getName(), is("test name NEW"));
        assertThat(tracker.getAll()[0].getCreated(), is(123123L));
        assertThat(tracker.getAll()[0].getDesc(), is("descNEW"));
        tracker.delete(item);
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNotThisItem() {
        Item item = new Item("test1", 123456L, "testDescription");
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(), "", "", "", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

//    /**
//     * MethodTest.
//     */
//    @Test
//    public void whenUserFindItemByIdThenShowThisItem() {
//        Item item = new Item("test1", 123456L, "testDescription");
//        tracker.add(item);
//        tracker.add(item);
//        Input input = new StubInput(new String[]{"4", item.getId(), "", "", "", "6"});
//        assertThat(new StartUI(input, tracker).init(), is(item));
//    }
}
