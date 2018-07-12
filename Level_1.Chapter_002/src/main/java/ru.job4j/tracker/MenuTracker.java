package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Класс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 27.04.2017
 */
public class MenuTracker {
    /**
     * Переменная типа Tracker.
     */
    private Tracker tracker;
    /**
     * Переменная типа Input.
     */
    private Input input;

    /**
     * @param input   - переменная типа Tracker.
     * @param tracker - переменная типа Input.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Список действий.
     */
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();
    /**
     * ADD.
     */
    private static final int ADD = 0;
    /**
     * SHOW.
     */
    private static final int SHOW = 1;
    /**
     * UPDATE.
     */
    private static final int UPDATE = 2;
    /**
     * DELETE.
     */
    private static final int DELETE = 3;
    /**
     * FINDBYID.
     */
    private static final int FINDBYID = 4;
    /**
     * FINDBYNAME.
     */
    private static final int FINDBYNAME = 5;
    /**
     * EXIT.
     */
    private static final int EXIT = 6;

    /**
     * Заполняет список действий.
     */
    public void fillActions() {
        actions.add(new AddItem());
        actions.add(new ShowItems());
        actions.add(new UpdateItem());
        actions.add(new DeleteItem());
        actions.add(new FindItemById());
        actions.add(new FindItemByName());
    }

    /**
     * Отображает список действий.
     */
    public void show() {
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }

    /**
     * @param action - новое действие.
     */
    public void addAction(UserAction action) {
        actions.add(action);
    }

    /**
     * @param key - номер действия.
     * @return - возвращает флаг продолжения вывода меню.
     */
    public boolean select(int key) {
        actions.get(key).execute(input, tracker);
        return key != EXIT;
    }

    /**
     * Добавление новой заявки.
     */
    private class AddItem extends BaseAction {
        /**
         * @return - возвращает номер действия.
         */
        public int key() {
            return ADD;
        }

        /**
         * @param input   - переменная интерфейса Input.
         * @param tracker - переменная класса Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input item's name: ");
            String desc = input.ask("Input description: ");
            long date = Long.parseLong(input.ask("Input date: "));
            tracker.add(new Item(name, date, desc));
        }

        /**
         * Конструктор.
         */
        private AddItem() {
            super(String.format("%s. %s", ADD, "Add the new item."));
        }
    }

    /**
     * Отображает список заявок.
     */
    private class ShowItems extends BaseAction {
        /**
         * @return - возвращает номер действия.
         */
        public int key() {
            return SHOW;
        }

        /**
         * Отображает список действий.
         *
         * @param input   - переменная интерфейса Input.
         * @param tracker - переменная класса Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc());
            }
        }

        /**
         * Конструктор.
         */
        private ShowItems() {
            super(String.format("%s. %s", SHOW, "Show all items."));
        }
    }

    /**
     * Редактирует заявку.
     */
    private class UpdateItem extends BaseAction {
        /**
         * @return - возвращает номер действия.
         */
        public int key() {
            return UPDATE;
        }

        /**
         * @param input   - переменная интерфейса Input.
         * @param tracker - переменная класса Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input ID: ");
            String newName = input.ask("Correct name: ");
            String desc = input.ask("Correct description: ");
            long newDate = Long.parseLong(input.ask("Correct date: "));
            tracker.update(new Item(id, newName, newDate, desc));
        }

        /**
         * Конструктор.
         */
        private UpdateItem() {
            super(String.format("%s. %s", UPDATE, "Update the item."));
        }
    }

    /**
     * Удаляет заявку.
     */
    private class DeleteItem extends BaseAction {
        /**
         * @return - возвращает номер действия.
         */
        public int key() {
            return DELETE;
        }

        /**
         * @param input   - переменная интерфейса Input.
         * @param tracker - переменная класса Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input ID: ");
            tracker.delete(new Item(id));
        }

        /**
         * Конструктор.
         */
        private DeleteItem() {
            super(String.format("%s. %s", DELETE, "Delete the item."));
        }
    }

    /**
     * Ищет заявку по Id.
     */
    private class FindItemById extends BaseAction {
        /**
         * @return - возвращает номер действия.
         */
        public int key() {
            return FINDBYID;
        }

        /**
         * @param input   - переменная интерфейса Input.
         * @param tracker - переменная класса Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input ID: ");
            Item item = tracker.findById(id);
            String text = "ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc();
            if (input instanceof StubOutput) {
                passItemText(input, text.toString());
            } else {
                System.out.println(text);
            }
        }

        /**
         * Конструктор.
         */
        private FindItemById() {
            super(String.format("%s. %s", FINDBYID, "Find item by id."));
        }
    }

    /**
     * Ищет заявку по имени.
     */
    private class FindItemByName extends BaseAction {
        /**
         * @return - возвращает номер действия.
         */
        public int key() {
            return FINDBYNAME;
        }

        /**
         * @param input   - переменная интерфейса Input.
         * @param tracker - переменная класса Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input item's name: ");
            ArrayList<Item> items = tracker.findByName(name);
            StringBuilder text = new StringBuilder();
            for (Item item : items) {
                text.append("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc() + System.getProperty("line.separator"));
            }
            if (input instanceof StubOutput) {
                passItemText(input, text.toString());
            } else {
                System.out.println(text);
            }
        }

        /**
         * Конструктор.
         */
        private FindItemByName() {
            super(String.format("%s. %s", FINDBYNAME, "Find item by name."));
        }
    }

    /**
     * @param input - объект интерфейса Input.
     * @param text  - текст для теста.
     */
    public void passItemText(Input input, String text) {
        ((StubOutput) input).setItemText(text);
    }
}
