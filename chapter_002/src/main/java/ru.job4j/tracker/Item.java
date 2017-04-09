package ru.job4j.tracker;

/**
 * Класс Item.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 05.04.2017
 */
public class Item {
    /**
     * id для автоматического проставления.
     */
    private static String position = "0";
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
     * @param name    - название заявки.
     * @param created - переменная.
     */
    public Item(String name, long created) {
        this.id = setId();
        this.name = name;
        this.created = created;
    }

    /**
     * @param id - id заявки.
     */
    public Item(String id) {
        this.id = id;
    }

    /**
     * @param id      - id заявки.
     * @param name    - название заявки.
     * @param created - переменная.
     */
    public Item(String id, String name, long created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    /**
     * Устанавливает id заяки.
     * @return - возвращает id звяки.
     */
    public String setId() {
        position = Integer.toString(Integer.parseInt(position) + 1);
        return position;
    }
}
