package ru.job4j.shape;

/**
 * класс Triangle.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 24.04.2017
 */
public class Triangle implements Shape {
    /**
     * Метод pic.
     *
     * @return - возвращает строку для рисования фигуры.
     */
    @Override
    public String pic() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= 9 - 5 + i; j++) {
                str.append(j >= 9 - 5 - i ? "*" : " ");
            }
            str.append(System.getProperty("line.separator"));
        }
        return str.toString();
    }
}
