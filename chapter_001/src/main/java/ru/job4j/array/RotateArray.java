package ru.job4j.array;
/**
 * Class RotateArray.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class RotateArray {
	/**
	 * Method rotate. Без дополнительного массива.
	 * @param array - array[][]
	 * @return - returns rotated array
	 */
	public int[][] rotate(int[][] array) {
		int beginLength = 0;
        	int length = array.length;
        	for (int j = array.length; j > 0; j -= 2, beginLength++, length--) {
            	int index = length - 1;
            		for (int i = beginLength; i < length - 1; i++, index--) {
                		int temp = array[i][length - 1];
                		array[i][length - 1] = array[beginLength][i];
                		int tempNew = array[length - 1][index];
                		array[length - 1][index] = temp;
                		temp = array[index][beginLength];
                		array[index][beginLength] = tempNew;
                		array[beginLength][i] = temp;
            		}
        	}
		return array;
	}
}