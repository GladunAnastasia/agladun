package ru.job4j.tracker;

/**
 * Класс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.04.2017
 */
public class Functions {
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
     * Выполнение пунктов из меню.
     *
     * @param tracker - объект класса Tracker.
     * @param input   - объект интерфейса Input.
     * @return - возвращает булево значение. Продолжать выводить меню или нет.
     */
    public boolean doFunction(Tracker tracker, Input input) {
        boolean doWhile = true;
        try {
            int number = Integer.parseInt(input.ask("Select: "));
            if (number == ADD) {
                if (tracker.findAll().length == tracker.getLength()) {
                    System.out.println("Overlimit");
                    System.out.println();
                    return doWhile;
                }
                String name = input.ask("Input item's name: ");
                String desc = input.ask("Input description: ");
                long date = Long.parseLong(input.ask("Input date: "));
                tracker.add(new Item(name, date, desc));
            } else if (number == SHOW) {
                for (Item item : tracker.findAll()) {
                    System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc());
                }
            } else if (number == UPDATE) {
                String id = input.ask("Input ID: ");
                String newName = input.ask("Correct name: ");
                String desc = input.ask("Correct description: ");
                long newDate = Long.parseLong(input.ask("Correct date: "));
                tracker.update(new Item(id, newName, newDate, desc));
            } else if (number == DELETE) {
                String id = input.ask("Input ID: ");
                tracker.delete(new Item(id));
            } else if (number == FINDBYID) {
                String id = input.ask("Input ID: ");
                Item item = tracker.findById(id);
                System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc());
            } else if (number == FINDBYNAME) {
                String name = input.ask("Input item's name: ");
                Item[] items = tracker.findByName(name);
                for (Item item : items) {
                    System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc());
                }
            } else if (number == EXIT) {
                doWhile = false;
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Input correct data");
        }
        return doWhile;
    }
}
