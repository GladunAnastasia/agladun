package ru.job4j.converter;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Converter Test.
 * @author AnastasiaGladun (netmislei@mail.ru)
 * @since 22.06.2018
 */
public class ConverterTest {
    /**
     * MethodTest.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }
    /**
     * MethodTest.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
}