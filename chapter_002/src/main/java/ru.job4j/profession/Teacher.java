package ru.job4j.profession;

/**
 * Класс Teacher.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Teacher extends Profession {
    /**
     * Метод teach.
     *
     * @param student - студент.
     * @return - возвращает строку.
     */
    public String teach(Person student) {
        return "Преподаватель " + getName() + " учит студента " + student.getName() + ".";
    }

    /**
     * Конструктор Teacher.
     *
     * @param name       - имя преподавателя.
     * @param education  - образование.
     * @param experience - стаж работы.
     */
    public Teacher(String name, Education education, Double experience) {
        super(name, education, experience);
    }
}
