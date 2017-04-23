package ru.job4j.shape;

/**
 * класс Square.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 24.04.2017
 */
public class Square implements Shape {
    /**
     * Метод pic.
     *
     * @return - возвращает строку для рисования фигуры.
     */
    @Override
    public String pic() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                str.append("*");
            }
            str.append(System.getProperty("line.separator"));
        }
        return str.toString();
    }
}
