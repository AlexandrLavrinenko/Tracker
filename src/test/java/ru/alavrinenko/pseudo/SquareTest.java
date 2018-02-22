package ru.alavrinenko.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String strExpected = String.format("%s%n%s%n%s%n%s%n%s","+++++", "+   +", "+   +", "+   +", "+++++");
        assertThat(square.draw(),is(strExpected));
    }
}