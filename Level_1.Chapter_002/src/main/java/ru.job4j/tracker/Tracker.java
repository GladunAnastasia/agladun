package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс Tracker.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 05.04.2017
 */
public class Tracker {
    /**
     * Массив объектов типа Item.
     */
    private ArrayList<Item> items = new ArrayList<Item>();
    /**
     * Номер позиции.
     */
    private int position;

    /**
     * Метод добавляет в массив items новый объект Item, а также возвращает добавляемый объект.
     *
     * @param item - объект типа Item.
     * @return - объект типа Item.
     */
    public Item add(Item item) {
        items.add(item);
        return item;
    }

    /**
     * Заменяет ячейку массива на переданный объект Item.
     *
     * @param item - объект типа Item.
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.set(i, item);
            }
        }
    }

    /**
     * Ищет в массиве объект с переданным в метод id.
     *
     * @param id - id объекта типа Item.
     * @return возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                return items.get(i);
            }
        }
        return null;
    }

    /**
     * Удаляет ячейку массива.
     *
     * @param item - объект типа Item.
     */
    public void delete(Item item) {
        String id = item.getId();
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
            }
        }
    }

    /**
     * Возвращает копию массива this.items без null элементов.
     *
     * @return возвращает копию массива this.items
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> itemsNew = new ArrayList<Item>();
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item != null) {
                itemsNew.add(item);
            }
        }
        return itemsNew;
    }

    /**
     * Метод возвращает массив объектов типа Item, которые содержат переданное название.
     *
     * @param key - название заявки
     * @return - возвращает массив объектов типа Item
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsNew = new ArrayList<Item>();
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getName().equals(key)) {
                itemsNew.add(item);
            }
        }
        return itemsNew;
    }

    /**
     * Возвращает массив.
     *
     * @return массив.
     */
    public ArrayList<Item> getAll() {
        return items;
    }

}
