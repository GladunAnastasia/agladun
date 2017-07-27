package ru.job4j.collections.pro.map;

import java.util.Calendar;

/**
 * Класс UserHashCodeAnnotation.
 *
 * @author Анастасия Гладун
 * @since 27.07.2017
 */
public class UserHashCodeAnnotation {
    private String name;
    private int children;
    private Calendar birthday;
    private boolean q;
    private byte w;
    private short e;
    private long r;
    private char t;
    private float y;
    private double u;

    @Override
    public int hashCode() {
        int result;
        long temp;
        // хэш-код объекта рассчитывается по его основным полям.
        // у полей ссылочного типа берется их хэш-код. Если поле равно null, то хэш-код = 0.
        result = name != null ? name.hashCode() : 0;
        // далее рассчитанный результат умножаем на 31 и к нему прибавляем значение поля children,
        // так как это поле содержит данные типа int(примитивного типа), то прибавляем не хэш-код, а само значение этого поля.
        result = 31 * result + children;
        // снова рассчитанный выше результат умножаем на 31 и прибавляем хэш-код следующего поля(так как он ссылочного типа).
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (q ? 1 : 0); // в случае с булевым типов при true прибавляем 1, при false прибавляем 0.
        result = 31 * result + (int) w; // byte расширяем до int.
        result = 31 * result + (int) e; // short расширяем до int.
        result = 31 * result + (int) (r ^ (r >>> 32)); // для long выполняем побитовые сдвиги и сужаем до int.
        result = 31 * result + (int) t; // char расширяем до int.
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        // Float.floatToIntBits - возвращает двоичное представление числа в виде int.
        temp = Double.doubleToLongBits(u); // Double.doubleToLongBits - возвращает двоичное представление числа в виде long.
        result = 31 * result + (int) (temp ^ (temp >>> 32)); // выполняем побитовые сдвиги и сужаем до int.
        return result;
    }
}
