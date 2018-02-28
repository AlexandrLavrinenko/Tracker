package ru.alavrinenko.start;

import org.junit.Test;
import ru.alavrinenko.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StubInputTest {
    // создаём Tracker
    Tracker tracker = new Tracker();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name 0", "desc 0", "6"});

        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.getAll()[0].getName(), is("test name 0"));
    }

    @Test
    public void whenAddOneTaskThenItsDisplayedInTheList() {
        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name 1", "desc 1", "1", "6"});

        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.getAll()[0].getName(), is("test name 1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());

        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name 2", "desc 2", "6"});

        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name 2"));
    }

    @Test
    public void whenAddTwoTasksAndDeleteOneThenDisplayedOneTask() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());

        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name 3", "desc 3", "6"});

        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.getAll()[0].getName(), is("test name 3"));
    }

    @Test
    public void whenAddOneTaskThenFindByItsID() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());

        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name 4", "desc 4",
                "4", item.getId(),
                "6"});

        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.getAll()[0].getName(), is("test name 4"));
    }

    @Test
    public void whenAddOneTaskThenFindByItsTaskName() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());

        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name 5", "desc 5",
                "5", "test name 5",
                "6"});

        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();

        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции
        assertThat(tracker.getAll()[0].getName(), is("test name 5"));
    }

}