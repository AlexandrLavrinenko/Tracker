package ru.alavrinenko.start;

/**
 *  Класс для тестирования поведения программы без ввода данных пользователем с клавиатуры
 */
public class StartUITest {

    public static void main(String[] args) {
//        Input input = new StubInput(new String[]{"Create stub task","2"});
//        String[] arrStr = new String[]{"0", "test name1", "desc1","6"};
        String[] arrStr = new String[]{"0", "test name1", "desc1","1","6"};
        Input input = new StubInput(arrStr);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        tracker.getAll();
    }
}
