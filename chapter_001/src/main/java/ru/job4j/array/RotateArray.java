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
		int r = 0;
        	int l = array.length;
        	for (int j = array.length; j > 0; j -= 2, r++, l--) {
            	int k = l - 1;
            		for (int i = r; i < l - 1; i++, k--) {
                		int t = array[i][l - 1];
                		array[i][l - 1] = array[r][i];
                		int m = array[l - 1][k];
                		array[l - 1][k] = t;
                		t = array[k][r];
                		array[k][r] = m;
                		array[r][i] = t;
            		}
        	}
		return array;
	}
}