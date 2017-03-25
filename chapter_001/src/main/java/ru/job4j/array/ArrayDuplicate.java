package ru.job4j.array;

import java.util.Arrays;
/**
 * Class ArrayDuplicate.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class ArrayDuplicate {
	/**
	 * Method remove.
	 * @param array - array[][]
	 * @return - returns array without duplicate
	 */
	public String[] remove(String[] array) {
        int end = 0;
        for (int i = 0; i < array.length - 1 - end; i++) {
            for (int j = i; j < array.length - 1 - end; j++) {
                if (array[i].equals(array[j + 1])) {
                    for (int k = array.length - 1 - end; k > 0; k--) {
                        if (array[j + 1].equals(array[array.length - 1 - end]) && j + 1 != array.length - 1 - end) {
                            end++;
                        } else {
				break;
			}
                    }
                    String t = array[array.length - 1 - end];
                    array[array.length - 1 - end] = array[j + 1];
                    array[j + 1] = t;
                    end++;
                }
            }
        }
        String[] arrayS = Arrays.copyOf(array, array.length - end);
        return arrayS;
    }
}