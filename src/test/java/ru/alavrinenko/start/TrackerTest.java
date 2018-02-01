package ru.alavrinenko.start;

import org.junit.Test;
import ru.alavrinenko.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {
    Tracker tracker = new Tracker();
    Item item1 = new Item("test1", "testDescription", 123L);
    Item item2 = new Item("test2", "testDescription2", 123L);
    Item item3 = new Item("exersise", "testDescription3", 123L);
    Item item4 = new Item("exersise", "testDescription4", 123L);
    Item item5 = new Item("test5", "testDescription5", 123L);
    Item item100 = new Item("test100", "testDescription100", 123L);

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        tracker.add(item1);
        assertThat(tracker.getAll()[0], is(item1));
    }

    @Test
    public void whenDeleteOneItemThenItemDeleted() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item3);

        Item[] itemsTest = {item1, item2, item4, item5};
        assertThat(tracker.getAll(), is(itemsTest));
    }

    @Test
    public void whenThereAreTwoCoincidencesByNameThenWeGetTwoValues() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        Item[] result = tracker.findByName("exersise");

        Item[] expected = new Item[2];
        expected[0] = tracker.items[2];
        expected[1] = tracker.items[3];
        assertThat(result, is(expected));
    }

    @Test
    public void whenUpdateNameThenReturnNewName() {
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(previous,next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
/*    public void whenUpdateNameThenReturnNewName() {
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }*/

    @Test
    public void whenRunGetAllThenShowAllItems() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] result = tracker.getAll();

        Item[] expected = new Item[4];
        expected[0] = tracker.items[0];
        expected[1] = tracker.items[1];
        expected[2] = tracker.items[2];
        expected[3] = tracker.items[3];
        assertThat(result, is(expected));
    }
}