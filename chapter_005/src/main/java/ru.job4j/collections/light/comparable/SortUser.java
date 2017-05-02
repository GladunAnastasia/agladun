package ru.job4j.collections.light.comparable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс SortUser.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 02.05.2017
 */
public class SortUser {
    /**
     * @param list - список пользователей.
     * @return - возвращает упорядоченное по возрасту множество пользователей.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> set = new TreeSet<User>();
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            set.add(it.next());
        }
        return set;
    }
}
