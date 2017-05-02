package ru.job4j.collections.light.comparable;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

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

    /**
     * @param list - список пользователей.
     * @return - отсортированный список пользователей по хэш коду.
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User user1, User user2) {
                return user1.hashCode() < user2.hashCode() ? -1 : (user1.hashCode() > user2.hashCode() ? 1 : 0);
            }
        });
        return list;
    }

    /**
     * @param list - список пользователей.
     * @return - отсортированный список пользователей по длине имени.
     */
    public List<User> sortLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User user1, User user2) {
                return user1.getName().length() - user2.getName().length();
            }
        });
        return list;
    }
}
