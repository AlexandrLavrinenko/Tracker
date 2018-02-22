package ru.alavrinenko.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String strExpected = String.format("%s%n%s%n%s%n%s%n%s","+", "++", "+ +", "+  +", "+++++");
        assertThat(triangle.draw(),is(strExpected));
    }
}