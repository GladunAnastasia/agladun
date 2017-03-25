package ru.job4j.loop;
/**
 * Class Factorial.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 23.03.2017
 */
public class Factorial {
	/**
	 * Method calc.
	 * @param n - n
	 * @return - returns factorial
	 */
	public int calc(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}