package ru.job4j.tracker;

/**
 * Класс Item.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 05.04.2017
 */
public class Item {
    /**
     * id - id заявки.
     */
    private String id;
    /**
     * name - тема заявки.
     */
    private String name;
    /**
     * desc - описание.
     */
    private String desc;
    /**
     * created.
     */
    private long created;
    /**
     * comments - комментарии.
     */
    private String[] comments;

    /**
     * @return возвращает id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return возвращает название.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param id   - id заявки.
     * @param name - название заявки.
     * @param created - переменная.
     */
    public Item(String id, String name, long created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}
