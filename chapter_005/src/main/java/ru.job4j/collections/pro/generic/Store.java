package ru.job4j.collections.pro.generic;

/**
 * Класс Store.
 *
 * @param <T> - класс унаследованный от абстрактного класса Base.
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 09.05.2017
 */
public interface Store<T extends Base> {
    /**
     * Добавляет значения.
     *
     * @param value - значение.
     */
    void add(T value);

    /**
     * Изменяет значения.
     *
     * @param id    - id.
     * @param value - значение.
     */
    void update(String id, T value);

    /**
     * Удаляет значение.
     *
     * @param id - id.
     */
    void delete(String id);

    /**
     * Ищет индекс значения по id.
     *
     * @param id - id.
     * @return - возвращает индекс.
     */
    int findIndexById(String id);
}
