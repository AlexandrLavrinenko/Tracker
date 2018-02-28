package ru.alavrinenko.start;

/**
 *  Класс для тестирования поведения программы без ввода данных пользователем с клавиатуры
 */
public class StartUITest {

    //        Input input = new StubInput(new String[]{"Create stub task","2"});
    private String[] arrStr = new String[]{"0", "test name1", "desc1", "1", "6"};
    private Tracker tracker = new Tracker();

    public void startTest(String[] arrStr) {

        Input input = new StubInput(arrStr);

        new StartUI(input, tracker).init();
        tracker.getAll();
}
    public static void main(String[] args) {
        StartUITest startUITest = new StartUITest();
        //startUITest.startTest(new String[]{"0", "test name1", "desc1", "1", "6"});
        startUITest.startTest(new String[]{"0", "test name1", "desc1",
                "2",
                //startUITest.tracker.getAll()[0].getId(),
                "1111","test", "desc",
                "1", "6"});
    }
}
