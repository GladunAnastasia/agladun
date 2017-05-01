package ru.job4j.collections.light;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Класс UserConvert.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 02.05.2017
 */
public class UserConvert {
    /**
     * @param list - список пользователей.
     * @return - возвращает map пользователей.
     */
    public HashMap<Integer, User> process(List<User> list) {
        Iterator<User> it = list.iterator();
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        while (it.hasNext()) {
            User user = it.next();
            map.put(user.getId(), user);
        }
        return map;
    }
}
