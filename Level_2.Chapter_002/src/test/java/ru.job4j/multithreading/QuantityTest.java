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
    public void thenEnterStringWhenGetWordQuantity() {
        Thread myFirstThread = new Thread(new WordQuantity("qwe ert tyu u ttt"));
        //Thread mySecondThread = new Thread(new SpaceQuantity("qwe ert tyu u ttt")); Закомментировала вторую нить, чтобы не мешалась.
        //mySecondThread.start();
        System.out.println("Start");
        myFirstThread.start();
        try {
            myFirstThread.join();
            //mySecondThread.join();
        } catch (Exception e) {
        }
        System.out.println("Finish");
    }

}
