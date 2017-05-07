package ru.job4j.collections.pro.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс IteratorConvert.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 06.05.2017
 */
public class IteratorConvertTest {
    /**
     * Test method.
     */
    @Test
    public void whenIteratorIteratorsConvertsIteratorThenIterator() {
        IteratorConvert itConvert = new IteratorConvert();
        List<Integer> list1 = Arrays.asList(new Integer[]{1, 2, 3, 4});
        List<Integer> list2 = Arrays.asList(new Integer[]{5, 6, 7});
        List<Integer> list3 = Arrays.asList(new Integer[]{8, 9, 10, 11});
        List<Iterator<Integer>> list = Arrays.asList(new Iterator[]{list1.iterator(), list2.iterator(), list3.iterator()});
        Iterator<Iterator<Integer>> itit = list.iterator();
        Iterator<Integer> it = (Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)).iterator();
        itConvert = (IteratorConvert) itConvert.convert(itit);
        while (itConvert.hasNext() || it.hasNext()) {
            assertThat(itConvert.next(), is(it.next()));
        }
    }
}