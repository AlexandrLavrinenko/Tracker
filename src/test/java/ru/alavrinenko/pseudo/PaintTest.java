package ru.alavrinenko.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;

/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PaintTest {
    // поле содержит дефолтный вывод в консоль
    private final PrintStream stdout = System.out;
    // буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before // выполняет метод, то запуска теста - заменяем стандартный вывод на вывод в пямять
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After  // выполняет метод, после запуска теста - возвращаем стандартный вывод в консоль
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        String strExpected = String.format("%s%n%s%n%s%n%s%n%s%n","+++++", "+   +", "+   +", "+   +", "+++++");
        assertThat(new String(out.toByteArray()),is(strExpected));
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        String strExpected = String.format("%s%n%s%n%s%n%s%n%s%n","+", "++", "+ +", "+  +", "+++++");
        assertThat(new String(out.toByteArray()),is(strExpected));
    }

}