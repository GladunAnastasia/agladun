package ru.job4j.tracker;

import java.util.Arrays;

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
    private Item[] items = new Item[10];
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
        this.items[position++] = item;
        return item;
    }

    /**
     * Заменяет ячейку массива на переданный объект Item.
     *
     * @param item - объект типа Item.
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
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
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                return items[i];
            }
        }
        return null;
    }

    /**
     * Печатает массив.
     */
    public void print() {
        for (Item it : items) {
            if (it != null) {
                System.out.println(it.getId() + " " + it.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
    }

    /**
     * Удаляет ячейку массива.
     *
     * @param item - объект типа Item.
     */
    public void delete(Item item) {
        String id = item.getId();
        //for (int j = items.length; j > 0; j--) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                System.out.println(position);
                items[position - 1] = null;
            }
        }
        //}
    }

    /**
     * Возвращает копию массива this.items без null элементов.
     *
     * @return возвращает копию массива this.items
     */
    public Item[] findAll() {
        for (int i = 0; i < position; i++) {
            if (items[i] == null) {
                System.arraycopy(items, i + 1, items, i, items.length - i-- - 1);
                position--;
            }
        }
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод возвращает массив объектов типа Item, которые содержат переданное название.
     *
     * @param key - название заявки
     * @return - возвращает массив объектов типа Item
     */
    public Item[] findByName(String key) {
        Item[] itemNew = new Item[10];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                itemNew[j++] = items[i];
            }
        }
        return Arrays.copyOf(itemNew, j);
    }

    /**
     * Возвращает массив.
     *
     * @return массив.
     */
    public Item[] getAll() {
        return Arrays.copyOf(items, position);
    }
}
