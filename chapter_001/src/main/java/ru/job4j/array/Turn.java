package ru.job4j.array;
/**
 * Class Turn.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class Turn {
	/**
	 * Method back.
	 * @param array - array
	 * @return - returns inverted array
	 */
	public int[] back(int[] array) {
		for (int i = 0; i < array.length; i++) {
            		int t = array[i];
            		array[i] = array[array.length - 1 - i];
            		array[array.length - 1 - i] = t;
            			if (i == array.length / 2 - 1) {
            	    			break;
            			}
        	}
		return array;
	}
}