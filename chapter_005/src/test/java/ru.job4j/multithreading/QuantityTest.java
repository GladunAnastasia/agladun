package ru.job4j.multithreading;

import org.junit.Test;

/**
 * Класс QuantityTest.
 *
 * @author Анастасия Гладун
 * @since 19.08.2017
 */
public class QuantityTest {
    /**
     * Тестовый метод.
     */
    @Test
    public void ThenEnterStringWhenGetWordQuantity() {
        Thread myFirstThread = new Thread(new WordQuantity("qwe ert tyu u ttt"));
        Thread mySecondThread = new Thread(new SpaceQuantity("qwe ert tyu u ttt"));
        myFirstThread.start();
        mySecondThread.start();
        try {
            mySecondThread.join();
            myFirstThread.join();
        } catch (Exception e) {
        }
    }
}
