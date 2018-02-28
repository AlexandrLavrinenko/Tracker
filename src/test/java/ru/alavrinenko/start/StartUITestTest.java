package ru.alavrinenko.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.alavrinenko.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITestTest {
    private Tracker tracker = new Tracker();
    private StartUITest startUITest = new StartUITest();
    private String startStr = String.format("%s %n%s %n%s %n%s %n%s %n%s %n%s%n%s",
            "0. Add new Item", "1. Show all items","2. Edit item", "3. Delete item",
            "4. Find item by Id", "5. Find items by name", "6. Exit Program", "Выбранная позиция: ");

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenSelectZeroPositionInTheMenu() {
                startUITest.startTest(new String[]{"0", "test name1", "desc1", "6"});
        String strExpected = String.format("%s%s%n%s%n%n%s%s%n%s%n",
                startStr,"0",
                "Новая заявка: test name1 создана",
                startStr,"6","Exit...");
        assertThat(new String(out.toByteArray()), is(strExpected));
    }

    @Test
    public void whenSelectSecondPositionInTheMenu() {
        Item item = tracker.add(new Item());

        Input input = new StubInput(new String[]{"2", item.getId(), "test name 2", "desc 2", "6"});
        new StartUI(input, tracker).init();
        String strExpected = String.format("%s%s%n%s%s%s%n%s%n%s%s%s%n%n%s%s%n%s%n",
                startStr,"2",
                "Заявка с ID: ", item.getId(),
                " обновлена!",
                "Новые параметры заявки: ",
                "Найдена заявка с ID: ", item.getId(),
                " с названием test name 2 с дескриптором desc 2",
                startStr,"6",
                "Exit...");
        assertThat(new String(out.toByteArray()), is(strExpected));
    }
}