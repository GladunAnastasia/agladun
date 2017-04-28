package ru.job4j.tracker;

/**
 * Класс Functions.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 27.04.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * @param question - вопрос.
     * @param range    - диапозон действий.
     * @return - возвращает номер позиции.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Please, select key from menu");
            } catch (NumberFormatException e) {
                System.out.println("Please, enter validate data again");
            }
        } while (invalid);
        return value;
    }

    /**
     * @param question - вопрос.
     * @return - возвращает текст для заполнения пунктов заявок.
     */
    @Override
    public String ask(String question) {
        boolean invalid = true;
        String value = "";
        do {
            try {
                value = super.ask(question);
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
