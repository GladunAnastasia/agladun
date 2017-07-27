package ru.job4j.collections.pro.map;

import java.util.Calendar;

/**
 * Класс User4.
 *
 * @author Анастасия Гладун
 * @since 24.07.2017
 */
public class User4 {
    private String name;
    private int children;
    private Calendar birthday;

    public User4(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {// проверяем равны ли ссылки на два объекта. Если ссылки равны, то объект один. Возвращаем true.
            return true;
        }
        if (o == null || o.getClass() != getClass()) {// если переменная o содержит пустую ссылку(то есть мы сравниваем объект с null),
            return false;                             // то возвращаем false.
        }                                             // если классы двух сравниваемых объектов не равны, то возвращаем false.

        User4 user = (User4) o; // производим сужение типа Object до User3.
        if (name != null ? !name.equals(user.name) : user.name != null) { // Далее начинаем сравнивать поля объектов.
            return false;// если поле name не равно null, то сравниваем эти поля объектов. Если они не равны(по методу equals),
        }                // то объекты не проходят проверку equals. Возвращаем false. В проверке других полей нет смысла.
        // если поле name равно null, а поле name другого объета не равно null, то возвращаем false.
        if (children != user.children) { // так как поле children не объектного типа, то для него достаточно проверки по одному условию.
            return false;                // если поля не равны, то возвращаем false.
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
        // если поле birthday не равно null, то сравниваем эти поля объектов. Если они не равны(по методу equals),
        // то объекты не проходят проверку equals. Возвращаем false. Так как это последнее проверяемое поле, то в противном случае возвращаем true.
        // если поле birthday равно null, а поле birthday другого объета не равно null, то возвращаем false. В противном случае возвращаем true.
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
