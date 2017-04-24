package ru.job4j.shape;

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
     * Test Method.
     */
    @Test
    public void whenChooseTriangleThenShowTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String separator = System.getProperty("line.separator");
        //assertThat(out.toString(), is("    *" + separator + "   ***" + separator + "  *****" + separator + " *******" + separator + "*********" + separator));
        assertThat(out.toString(), is(String.format("    *%s   ***%<s  *****%<s *******%<s*********%<s", separator)));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenChooseSquareThenShowSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.draw(new Square());
        String separator = System.getProperty("line.separator");
        assertThat(out.toString(), is(String.format("*****%s*****%<s*****%<s*****%<s*****%<s", separator)));
    }
}
