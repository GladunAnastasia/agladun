package ru.job4j.pingpong;


import javafx.scene.shape.Rectangle;

/**
 * Класс RectangleMove.
 *
 * @author Анастасия Гладун
 * @since 12.07.2018
 */
public class RectangleMove implements Runnable {
    /**
     * Квадрат.
     */
    private Rectangle rect;

    /**
     * Конструктор.
     *
     * @param rect - квадрат.
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    /**
     * Реализация метода run.
     */
    @Override
    public void run() {
        double x = 0;
        double y = 0;
        while (true) {
            double tempX = this.rect.getX();
            double tempY = this.rect.getY();
            if (tempX <= 5) {
                y = Math.random() * 1.8 - 0.9;
                x = Math.sqrt(1 - y * y);
            } else if (tempX >= 295) {
                y = Math.random() * 1.8 - 0.9;
                x = -Math.sqrt(1 - y * y);
            } else if (tempY <= 5) {
                x = Math.random() * 1.8 - 0.9;
                y = Math.sqrt(1 - x * x);
            } else if (tempY >= 295) {
                x = Math.random() * 1.8 - 0.9;
                y = -Math.sqrt(1 - x * x);
            }
            this.rect.setX(tempX + x * 5);
            this.rect.setY(tempY + y * 5);
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
