package ru.job4j.shape;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * класс PaintTest.
 *
 * @author Анастасия Гладун (netmislei@mail.ru)
 * @since 24.04.2017
 */
public class PaintTest {
    /**
     * Дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Установка вывода результата в буфер.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    /**
     * Установка стандартного вывода результата на консоль.
     */
    @After
    public void backOutput() {
        System.setOut(stdout);
    }
    /**
     * Test Method.
     */
    @Test
    public void whenChooseTriangleThenShowTriangle() {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String separator = System.getProperty("line.separator");
        assertThat(out.toString(), is(String.format("    *%s   ***%<s  *****%<s *******%<s*********%<s", separator)));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenChooseSquareThenShowSquare() {
        Paint paint = new Paint();
        paint.draw(new Square());
        String separator = System.getProperty("line.separator");
        assertThat(out.toString(), is(String.format("*****%s*****%<s*****%<s*****%<s*****%<s", separator)));
    }
}
