package ru.job4j.profession;

/**
 * Класс Engineer.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class Engineer extends Profession {
    /**
     * Метод doProject.
     *
     * @param project - проект.
     * @return - возвращает строку.
     */
    public String doProject(Project project) {
        return "Инженер " + getName() + " делает проект \"" + project.getName() + "\". Уже сделано " + project.getPercentCompletion() + "%.";
    }

    /**
     * Конструктор Engineer.
     *
     * @param name - имя инженера.
     * @param education - образование инженера.
     * @param experience - стаж работы инженера.
     */
    public Engineer(String name, Education education, Double experience) {
        super(name, education, experience);
    }
}
