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
     * MethodTest.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "", "test name", "desc", "123", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenWantToSeeAllItemThenShowAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", 123456L, "testDescription");
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "", "", "", "", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUserUpdateItemThenTrackerHasUpdateItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", 123456L, "testDescription");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test name NEW", "descNEW", "123123", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getId(), is(item.getId()));
        assertThat(tracker.getAll()[0].getName(), is("test name NEW"));
        assertThat(tracker.getAll()[0].getCreated(), is(123123L));
        assertThat(tracker.getAll()[0].getDesc(), is("descNEW"));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", 123456L, "testDescription");
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(), "", "", "", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUserFindItemByIdThenShowThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", 123456L, "testDescription1");
        Item item2 = new Item("test2", 123456L, "testDescription2");
        Item item3 = new Item("test3", 123456L, "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Input input = new StubOutput(new String[]{"4", item3.getId(), "", "", "", "6"});
        new StartUI(input, tracker).init();
        assertThat(((StubOutput) input).getText(), is("ID: " + item3.getId() + " Name: " + item3.getName() + " Description: " + item3.getDesc()));
    }

    /**
     * MethodTest.
     */
    @Test
    public void whenUserFindItemByNameThenShowThisItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", 123456L, "testDescription1");
        Item item2 = new Item("test2", 123456L, "testDescription2");
        Item item3 = new Item("test3", 123456L, "testDescription3");
        Item item4 = new Item("test2", 123456L, "testDescription4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Input input = new StubOutput(new String[]{"5", "", item2.getName(), "", "", "6"});
        new StartUI(input, tracker).init();
        assertThat(((StubOutput) input).getText(), is("ID: " + item2.getId() + " Name: " + item2.getName() + " Description: " + item2.getDesc() + System.getProperty("line.separator") + "ID: " + item4.getId() + " Name: " + item4.getName() + " Description: " + item4.getDesc() + System.getProperty("line.separator")));
    }
}
