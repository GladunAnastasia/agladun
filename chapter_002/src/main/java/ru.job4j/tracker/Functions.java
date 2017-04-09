package ru.job4j.tracker;

/**
 * Класс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class Functions {
    /**
     * Выполнение пунктов из меню.
     * @param tracker - объект класса Tracker.
     * @param input - объект интерфейса Input.
     * @return - возвращает булево значение. Продолжать выводить меню или нет.
     */
    public boolean doFunction(Tracker tracker, Input input) {
        boolean doWhile = true;
        try {
            int number = Integer.parseInt(input.ask("Select: "));
            if (number == 0) {
                if (tracker.findAll().length == tracker.getLength()) {
                    System.out.println("Overlimit");
                    System.out.println();
                    return doWhile;
                }
                String name = input.ask("Input item's name: ");
                long date = Integer.parseInt(input.ask("Input date: "));
                tracker.add(new Item(name, date));
            } else if (number == 1) {
                for (Item item : tracker.findAll()) {
                    System.out.println("ID: " + item.getId() + " Name: " + item.getName());
                }
            } else if (number == 2) {
                String id = input.ask("Input ID: ");
                String newName = input.ask("Correct name: ");
                long newDate = Integer.parseInt(input.ask("Input date: "));
                tracker.update(new Item(id, newName, newDate));
            } else if (number == 3) {
                String id = input.ask("Input ID: ");
                tracker.delete(new Item(id));
            } else if (number == 4) {
                String id = input.ask("Input ID: ");
                Item item = tracker.findById(id);
                System.out.println("ID: " + item.getId() + " Name: " + item.getName());
            } else if (number == 5) {
                String name = input.ask("Input item's name: ");
                Item[] items = tracker.findByName(name);
                for (Item item : items) {
                    System.out.println("ID: " + item.getId() + " Name: " + item.getName());
                }
            } else if (number == 6) {
                doWhile = false;
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Input correct data");
        }
        return doWhile;
    }
}
