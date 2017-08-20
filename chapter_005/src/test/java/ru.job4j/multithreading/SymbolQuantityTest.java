package ru.job4j.multithreading;

import org.junit.Test;

/**
 * Класс SymbolQuantityTest.
 *
 * @author Анастасия Гладун
 * @since 20.08.2017
 */
public class SymbolQuantityTest {
    /**
     * Тестовый метод.
     */
    @Test
    public void whenThen() {
        Thread timeThread = new Thread(new Time());
        timeThread.start();
        try {
            timeThread.join();
        } catch (Exception e) {
        }
    }
}
