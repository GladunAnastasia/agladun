package ru.job4j.tracker;

/**
 * Класс StartUI.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class StartUI {
    /**
     * Диапозон действий.
     */
    private int[] range = {0, 1, 2, 3, 4, 5, 6};
    /**
     * Переменная интерфейса Input.
     */
    private Input input;
    /**
     * Переменная для меню.
     */
    private String startMenu;
    /**
     * Переменная для объекта класса Tracker.
     */
    private Tracker tracker;

    /**
     * Main.
     *
     * @param args - входящие параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }

    /**
     * Конструктор StartUI.
     *
     * @param input   - переменная, содержащая объект одного из классов, которые реализуют интерфейс Input.
     * @param tracker - переменная, содержащая объект типа Tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод начала работы программы.
     */
    public void init() {
        MenuTracker functions = new MenuTracker(input, tracker);
        BaseAction deleteItem = new BaseAction(String.format("%s. %s", 6, "Exit the programm.")) {
            @Override
            public int key() {
                return 6;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
            }
        };
        functions.fillActions();
        functions.addAction(deleteItem);
        boolean doWhile = true;
        for (; doWhile;) {
            functions.show();
            int number = Integer.valueOf((input).ask("Select: ", range));
            doWhile = functions.select(number);
        }
    }
}
