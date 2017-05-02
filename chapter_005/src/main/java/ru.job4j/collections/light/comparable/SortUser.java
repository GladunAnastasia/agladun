package ru.job4j.collections.light.comparable;

import java.util.*;

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

    public static void main(String[] args) {
        SortUser sortUser = new SortUser();
        User userOne = new User("Max", 25);
        User userTwo = new User("Denis", 35);
        User userThree = new User("Alex", 19);
        User userFour = new User("Andrei", 25);
        User userFive = new User("Artem", 17);
        User userSix = new User("Dmitrii", 29);
        ArrayList<User> list = new ArrayList<User>();
        list.add(userOne);
        list.add(userTwo);
        list.add(userThree);
        list.add(userFour);
        list.add(userFive);
        list.add(userSix);
        Set<User> set = sortUser.sort(list);
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
