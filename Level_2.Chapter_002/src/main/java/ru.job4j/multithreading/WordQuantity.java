package ru.job4j.multithreading;

import java.util.Date;

/**
 * Класс Quality.
 *
 * @author Анастасия Гладун
 * @since 19.08.2017
 */
public class WordQuantity implements Runnable {
    /**
     * Переменная для строки.
     */
    private String str;

    /**
     * Конструктор.
     *
     * @param str - строка.
     */
    public WordQuantity(String str) {
        this.str = str;
    }

    /**
     * Переопределенный метод run().
     */
    @Override
    public void run() {
        Date dDate = new Date();
        int countW = 0;
        char[] charStr = str.toCharArray();
        if (charStr.length != 0) {
            countW++;
        }
        for (int i = 0; i < charStr.length; i++) {
            if (" ".equals(Character.toString(charStr[i]))) {
                countW++;
            }
        }
        try { // Если закомментировать этот блок, то нить прервется.
            Thread.sleep(3000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if ((new Date()).getTime() - dDate.getTime() > 1000) {
            Thread.currentThread().interrupt();
        }
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(countW);
        }
    }
}
