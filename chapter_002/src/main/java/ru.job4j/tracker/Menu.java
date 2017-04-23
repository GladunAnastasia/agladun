package ru.job4j.tracker;

/**
 * Класс Menu.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class Menu {
    /**
     * Пункты меню.
     */
    private String[] menu = new String[7];
    /**
     * Индекс в массиве.
     */
    private int position;

    /**
     * Выводит все пункты меню одной строкой.
     *
     * @return - строка меню.
     */
    public String makeMenu() {
        menu[position++] = "0. Add new Item";
        menu[position++] = "1. Show all items";
        menu[position++] = "2. Edit item";
        menu[position++] = "3. Delete item";
        menu[position++] = "4. Find item by Id";
        menu[position++] = "5. Find items by name";
        menu[position++] = "6. Exit Program";
        StringBuilder menuString = new StringBuilder();
        for (int i = 0; i < this.menu.length; i++) {
            menuString.append(this.menu[i] + System.getProperty("line.separator"));
        }
        return menuString.toString();
    }
}
