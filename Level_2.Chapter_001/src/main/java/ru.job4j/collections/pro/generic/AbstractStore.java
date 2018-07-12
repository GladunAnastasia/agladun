package ru.job4j.collections.pro.generic;

/**
 * Класс AbstractStore.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 10.05.2017
 * @param <T> - параметр.
 */
public class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Счетчик позиций.
     */
    private String position = "0";
    /**
     * Хранилище.
     */
    private SimpleArray<T> simple = new SimpleArray<>();

    /**
     * Добавляет в значение в хранилище.
     *
     * @param value - значение.
     */
    public void add(T value) {
        position = String.valueOf(Integer.parseInt(position) + 1);
        value.setId(position);
        simple.add(value);
    }

    /**
     * Изменяет значение в хранилище.
     *
     * @param id    - id.
     * @param value - значение.
     */
    public void update(String id, T value) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Элемента с id " + id + " нет в информационной базе.");
            return;
        }
        value.setId(simple.get(index).getId());
        simple.update(index, value);
    }

    /**
     * Удаляет значение из хранилища.
     *
     * @param id - id.
     */
    public void delete(String id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Элемента с id " + id + " нет в информационной базе.");
            return;
        }
        simple.delete(index);
    }

    /**
     * Ищет индекс значения в хранилище по id.
     *
     * @param id - id.
     * @return - возвращает индекс.
     */
    public int findIndexById(String id) {
        for (int i = 0; i < simple.getLength(); i++) {
            if (simple.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return - возвращает SimpleArray.
     */
    public SimpleArray<T> getArray() {
        return simple;
    }
}
