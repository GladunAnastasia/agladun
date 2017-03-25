package ru.job4.loop;
/**
 * Class Paint.
 * @author Anastasia Gladun (netmislei@mail.ru)
 * @version 1.6
 * @since 25.03.2017
 */
public class Paint {
	/**
	 * Method piramid.
	 * @param h - height
	 * @return - returns pyramid
	 */
	public String piramid(int h) {
        StringBuilder sb = new StringBuilder();
		for (int i = 1; i < h + 1; i++) {
            for (int j = 0; j < h - i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append("^");
            }
            for (int j = 0; j < h - i; j++) {
                sb.append(" ");
            }
            if (i != h) {
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }
}