package ru.job4j.multithreading;

/**
 * Класс SpaceQuantity.
 *
 * @author Анастасия Гладун
 * @since 19.08.2017
 */
public class SpaceQuantity implements Runnable {
    /**
     * Переменная для строки.
     */
    private String str;

    /**
     * Конструктор.
     *
     * @param str - строка.
     */
    public SpaceQuantity(String str) {
        this.str = str;
    }

    /**
     * Переопределенный метод run().
     */
    @Override
    public void run() {
        int countW = 0;
        char[] charStr = str.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            if (" ".equals(Character.toString(charStr[i]))) {
                countW++;
            }
        }
        System.out.println(countW);
    }
}
