package ru.job4j.multithreading;

/**
 * Класс CountChar.
 *
 * @author Анастасия Гладун
 * @since 20.08.2017
 */
public class CountChar implements Runnable {
    /**
     * Переменная.
     */
    private String str;

    /**
     * Конструктор.
     *
     * @param str
     */
    public CountChar(String str) {
        this.str = str;
    }

    /**
     * Переопределенный метод run().
     */
    @Override
    public void run() {
        try {
            Thread.sleep(0);
            char[] arrayStr = str.toCharArray();
            System.out.println(arrayStr.length);
        } catch (InterruptedException e) {
        }
    }

}
