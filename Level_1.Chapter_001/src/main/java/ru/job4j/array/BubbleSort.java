package ru.job4j.array;
/**
 * Class BubbleSort.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class BubbleSort {
	/**
	 * Method sort.
	 * @param array - array
	 * @return - returns sorted array
	 */
	public int[] sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[i] > array[j + 1]) {
                    int y = array[i];
                    array[i] = array[j + 1];
                    array[j + 1] = y;
                }
            }
        }
		return array;
	}
}