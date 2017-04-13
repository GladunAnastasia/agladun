package ru.job4j.tracker;

/**
 * Класс StartUI.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class StartUI {
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
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
        startMenu = new Menu().makeMenu();
        boolean doWhile = true;
        for (; doWhile;) {
            System.out.print(startMenu);
            doWhile = new Functions().doFunction(tracker, input);
        }
    }
}
