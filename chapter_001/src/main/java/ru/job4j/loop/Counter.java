package ru.job4j.loop;
/**
 * Class Counter.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 23.03.2017
 */
public class Counter {
	/**
	 * Method add.
	 * @param start - start
	 * @param finish - finish
	 * @return - returns even numbers
	 */
	public int add(int start, int finish) {
        int sum = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                sum += start;
			}
        }
        return sum;
    }
}