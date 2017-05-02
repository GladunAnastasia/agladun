package ru.job4j.collections.light.comparable;

/**
 * Класс User.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 02.05.2017
 */
public class User implements Comparable<User> {
    /**
     * Имя.
     */
    private String name;
    /**
     * Возвраст.
     */
    private int age;

    /**
     * @param name - имя.
     * @param age  - возвраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @param user - пользователь для сравнения.
     * @return - возвращает -1, если левый операнд меньше или равен правому, и возвращает 1 в противном случае.
     */
    @Override
    public int compareTo(User user) {
        //return Integer.compare(age, user.age);
        return Integer.valueOf(age).compareTo(user.age);
        //return ((age < user.age) ? -1 : age > user.age ? 1 : 0);
        //return ((age < user.age) ? -1 : 1);
    }

    /**
     * @return - возвращает имя.
     */
    public String getName() {
        return name;
    }
}
