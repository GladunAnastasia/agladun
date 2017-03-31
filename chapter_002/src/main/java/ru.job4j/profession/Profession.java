package ru.job4j.profession;

/**
 * Класс Profession.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Profession {
    /**
     * Имя специалиста.
     */
    private String name;
    /**
     * Образование.
     */
    private Education education;
    /**
     * Стаж работы.
     */
    private Double experience;

    /**
     * Метод getName.
     *
     * @return - возвращает имя специалиста.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод getEducation.
     *
     * @return - возвращает образование специалиста.
     */
    public Education getEducation() {
        return this.education;
    }

    /**
     * Метод getExperience.
     *
     * @return - возвращает стаж работы специалиста.
     */
    public Double getExperience() {
        return this.experience;
    }

    /**
     * Конструктор Profession.
     *
     * @param name       - имя специалиста.
     * @param education  - образование специалиста.
     * @param experience - стаж работы специалиста.
     */
    public Profession(String name, Education education, Double experience) {
        this.name = name;
        this.education = education;
        this.experience = experience;
    }

    /**
     * Конструктор Profession.
     */
    public Profession() {

    }
}
