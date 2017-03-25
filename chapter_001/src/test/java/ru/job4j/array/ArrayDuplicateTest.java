package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ArrayDuplicateTest.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class ArrayDuplicateTest {
	/**
	 * Method.
	 */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] array =  {"Привет", "Мир", "Привет", "Супер", "Мир"};
		ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
		array = arrayDuplicate.remove(array);
		assertThat(array, is(new String[] {"Привет", "Мир", "Супер"}));
    }
	/**
	 * Method.
	 */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateTwo() {
        String[] array =  {"Привет", "Мир", "Мир", "Супер", "Мир", "Яблоко", "Привет", "Коктейль", "Коктейль", "Привет", "Мир", "Мир", "Йогурт"};
		ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
		array = arrayDuplicate.remove(array);
		assertThat(array, is(new String[] {"Привет", "Мир", "Коктейль", "Супер", "Йогурт", "Яблоко"}));
    }
}