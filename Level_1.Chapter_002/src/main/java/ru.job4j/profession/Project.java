package ru.job4j.profession;

/**
 * Класс Project.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Project {
    /**
     * Название проекта.
     */
    private String name;
    /**
     * Миссия проекта.
     */
    private String mission;
    /**
     * Процент выполнения.
     */
    private int percentCompletion;

    /**
     * Конструктор Project.
     *
     * @param name    - название проекта.
     * @param mission - миссия проекта.
     */
    public Project(String name, String mission) {
        this.name = name;
        this.mission = mission;
    }

    /**
     * Метод getName.
     *
     * @return - возвращает название проекта.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод getMission.
     *
     * @return - возвращает миссию проекта.
     */
    public String getMission() {
        return mission;
    }

    /**
     * Метод getPercentCompletion.
     *
     * @return - возвращает процент выполнения проекта.
     */
    public int getPercentCompletion() {
        return percentCompletion;
    }

    /**
     * Метод setPercentCompletion.
     * Устанавливает процент выполнения проекта.
     *
     * @param percentCompletion - процент выполнения проекта.
     */
    public void setPercentCompletion(int percentCompletion) {
        this.percentCompletion = percentCompletion;
    }
}
