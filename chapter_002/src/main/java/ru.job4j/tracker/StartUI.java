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
     * Main.
     *
     * @param args - входящие параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }

    /**
     * Конструктор StartUI.
     *
     * @param inputMenu - Строка, содержащая все пункты меню.
     */
    public StartUI(Input inputMenu) {
        this.input = inputMenu;
    }

    /**
     * Метод начала работы программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        startMenu = new Menu().makeMenu();
        boolean doWhile = true;
        for (; doWhile;) {
            System.out.print(startMenu);
            doWhile = new Functions().doFunction(tracker, input);
        }
    }
}
