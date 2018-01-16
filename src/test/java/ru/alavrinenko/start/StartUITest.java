package ru.alavrinenko.start;

// класс из видео - доп.реализации не было
public class StartUITest {

    public static void main(String[] args) {
        Input input = new StubInput(new String[]{"Create stub task"});
        new StartUI(input).init();
    }
}
