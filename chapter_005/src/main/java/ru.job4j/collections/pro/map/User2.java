package ru.job4j.collections.pro.map;

import java.util.Calendar;

/**
 * Класс User2.
 *
 * @author Анастасия Гладун
 * @since 24.07.2017
 */
public class User2 {
    private String name;
    private int children;
    private Calendar birthday;

    public User2(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        // хэш-код объекта рассчитывается по его основным полям.
        int result = name != null ? name.hashCode() : 0; // у полей ссылочного типа берется их хэш-код. Если поле равно null, то хэш-код = 0.
        result = 31 * result + children; // далее рассчитанный результат умножаем на 31 и к нему прибавляем значение поля children,
        // так как это поле содержит данные типа int, то прибавляем не хэш-код, а само значение этого поля.
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0); // снова рассчитанный выше результат умножаем на 31 и прибавляем хэш-код
        return result;                                                       // следующего поля.
    }
}
