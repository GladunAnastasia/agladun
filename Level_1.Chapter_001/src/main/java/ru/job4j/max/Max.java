package ru.job4j.max;

/**
 * Maximum value Test.
 *
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @version 1.4
 * @since 23.03.2017
 */
public class Max {
	/**
	 * Method returns maximum value.
	 * @param first - first operand
	 * @param second - second operand
	 * @return maximum value
	 */
	public int max(int first, int second) {
		return first > second ? first : second;
	}
	/**
	 * Method returns maximum value.
	 * @param first - first operand
	 * @param second - second operand
	 * @param third - third operand
	 * @return maximum value
	 */
	 public int max(int first, int second, int third) {
		return max(max(first, second), third);
	 }
}