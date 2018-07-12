package ru.job4j.profession;

/**
 * Класс Doctor.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Doctor extends Profession {
    /**
     * Метод heal.
     *
     * @param patient - пациент.
     * @return - возвращает строку.
     */
    public String heal(Person patient) {
        return "Доктор " + getName() + " лечит пациента " + patient.getName() + ".";
    }

    /**
     * Конструктор Doctor.
     *
     * @param name       - имя доктора.
     * @param education  - образование.
     * @param experience - стаж работы.
     */
    public Doctor(String name, Education education, Double experience) {
        super(name, education, experience);
    }
}
