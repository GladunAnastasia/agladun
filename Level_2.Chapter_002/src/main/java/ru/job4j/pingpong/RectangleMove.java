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
    private volatile Rectangle rect;
    /**
     * Флаг для обновления положения квадрата.
     */
    private volatile boolean process = false;
    /**
     * Координата по оси x.
     */
    private volatile double x;
    /**
     * Координата по оси y.
     */
     private volatile double y;
     /**
     * Конструктор.
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
        if (process) {
            while (true) {
                this.rect.setX(this.rect.getX() + x * 5);
                this.rect.setY(this.rect.getY() + y * 5);
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            process = true;
            new Thread(this).start();
            double tempX = 0;
            double tempY = 0;
            boolean[] check = {false, false, false, false, false, false, false, false};
            while (true) {
                tempX = this.rect.getX();
                tempY = this.rect.getY();
                if (tempX <= 5 && tempY >= 5 && tempY <= 295 && !check[0]) {
                    check[0] = true;
                    y = Math.random() * 1.8 - 0.9;
                    x = Math.sqrt(1 - y * y);
                    resetCheck(check, 0);
                } else if (tempX >= 295 && tempY >= 5 && tempY <= 295 && !check[1]) {
                    check[1] = true;
                    y = Math.random() * 1.8 - 0.9;
                    x = -Math.sqrt(1 - y * y);
                    resetCheck(check, 1);
                } else if (tempY <= 5 && tempX >= 5 && tempX <= 295 && !check[2]) {
                    check[2] = true;
                    x = Math.random() * 1.8 - 0.9;
                    y = Math.sqrt(1 - x * x);
                    resetCheck(check, 2);
                } else if (tempY >= 295 && tempX >= 5 && tempX <= 295 && !check[3]) {
                    check[3] = true;
                    x = Math.random() * 1.8 - 0.9;
                    y = -Math.sqrt(1 - x * x);
                    resetCheck(check, 3);
                } else if (tempX <= 5 && tempY <= 5 && !check[4]) {
                    revertDirection(check, 4);
                } else if (tempX >= 295 && tempY <= 5 && !check[5]) {
                    revertDirection(check, 5);
                } else if (tempX <= 5 && tempY >= 295 && !check[6]) {
                    revertDirection(check, 6);
                } else if (tempX >= 295 && tempY >= 295 && !check[7]) {
                    revertDirection(check, 7);
                }
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Метод для перезагрузки массива check.
     * @param check - массив с флагами.
     * @param index - индекс.
     */
    private void resetCheck(boolean[] check, int index) {
        for (int i = 0; i < check.length; i++) {
            if (i != index) {
                check[i] = false;
            }
        }
    }

    /**
     * Метод установки противоположных по значению координат.
     * @param check - массив с флагами.
     * @param index - индекс.
     */
    private void revertDirection(boolean[] check, int index) {
        check[index] = true;
        x = -x;
        y = -y;
        resetCheck(check, index);
    }
}
