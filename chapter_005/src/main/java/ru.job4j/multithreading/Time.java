package ru.job4j.multithreading;

import java.util.Date;

/**
 * Класс Time.
 *
 * @author Анастасия Гладун
 * @since 20.08.2017
 */
public class Time implements Runnable {
    /**
     * Нить.
     */
    Thread countThread = new Thread(new CountChar("wer3 45 gfh"));

    /**
     * Переопределенный метод run().
     */
    @Override
    public void run() {
        Date d1 = new Date();
        countThread.start();
        while (new Date().getTime() - d1.getTime() < 1000) {
        }
        countThread.interrupt();
        Thread.currentThread().interrupt();
    }
}
