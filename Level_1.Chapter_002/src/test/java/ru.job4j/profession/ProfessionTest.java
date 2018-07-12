package ru.job4j.profession;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс ProfessionTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @version 0.1
 * @since 01.04.2017
 */
public class ProfessionTest {
    /**
     * Массив professions.
     */
    private Profession[] professions = new Profession[3];

    /**
     * Метод whenCreateNewProfessionThenPrintThem.
     */
    @Test
    public void whenCreateNewProfessionThenPrintThem() {
        ProfessionTest profession = new ProfessionTest();
        profession.professions[0] = new Doctor("Ирина", new Education("Высшее медицинское образование"), 2.5);
        profession.professions[1] = new Engineer("Алексей", new Education("Высшее техническое образование"), 7.0);
        profession.professions[2] = new Teacher("Дмитрий", new Education("Высшее экономическое образование"), 4.0);
        StringBuilder str1 = new StringBuilder();
        for (Profession prof : profession.professions) {
            if (prof instanceof Doctor) {
                str1.append(((Doctor) prof).heal(new Person("Денис")));
            } else if (prof instanceof Engineer) {
                Project project = new Project("Внедрение электронного документооборота", "Быстро, профессионально, дешево внедрить документооборот на оптовых складах.");
                project.setPercentCompletion(20);
                str1.append(((Engineer) prof).doProject(project));
            } else {
                str1.append(((Teacher) prof).teach(new Person("Карина")));
            }
        }
        String str2 = "Доктор Ирина лечит пациента Денис.Инженер Алексей делает проект \"Внедрение электронного документооборота\". Уже сделано 20%.Преподаватель Дмитрий учит студента Карина.";
        assertThat(str1.toString(), is(str2));
    }
}
