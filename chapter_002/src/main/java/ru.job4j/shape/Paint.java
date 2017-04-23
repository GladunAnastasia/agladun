package ru.job4j.shape;

/**
 * класс Paint.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 24.04.2017
 */
public class Paint {
    /**
     * Рисует фигуру.
     *
     * @param shape - переменная типа Shape.
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}
