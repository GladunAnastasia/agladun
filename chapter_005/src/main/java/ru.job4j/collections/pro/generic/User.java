package ru.job4j.collections.pro.generic;

/**
 * Класс Base.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 09.05.2017
 */
public class User extends Base {
    /**
     * Id.
     */
    private String id;

    /**
     * @return - возвращает id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id - устанавливает id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
