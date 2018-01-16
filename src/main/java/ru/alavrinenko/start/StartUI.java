package ru.alavrinenko.start;

import ru.alavrinenko.models.*;

public class StartUI {
    private Input input;
    private static final int ADDNEW = 0;
    private static final int SHOWALL = 1;
    private static final int EDIT = 2;
    private static final int DEL = 3;
    private static final int IDFIND = 4;
    private static final int NAMEFIND = 5;
    private static final int EXIT = 6;
    private int pos;

    /**
     * Инициализация параметров с помощью конструктора.
     *
     * @param input тип ввода (коноль или тест).
     */
    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        String name = input.ask("Please, enter the task's name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Item(name, "first desc", System.currentTimeMillis()));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
    }

    /**
     * Выводим на экран меню доступных действий.
     */
    private void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("0. Add new Item" + System.lineSeparator());
        sb.append("1. Show all items" + System.lineSeparator());
        sb.append("2. Edit item" + System.lineSeparator());
        sb.append("3. Delete item" + System.lineSeparator());
        sb.append("4. Find item by Id" + System.lineSeparator());
        sb.append("5. Find items by name" + System.lineSeparator());
        sb.append("6. Exit Program" + System.lineSeparator());
        System.out.println(sb.toString());
    }


    /**
     * Вывод вопроса о выборе номера действия на экран.
     *
     * @return номер позиции для действия.
     */
    public void selectPosition() {
        this.printMenu();
        String resultStr = input.ask("Select: ");
        if (resultStr.isEmpty()) {
            int result = 6;
        }
        int result = Integer.parseInt(resultStr);
        this.pos = result;
    }

    /**
     * Реализация соответсвующих пунктов меню, согласно выбора пользователя.
     *
     * @param tracker  трекер.
     * @param position выбранный пользователем номер позиции в меню.
     */
    public void actionMenu(Tracker tracker, int position) {
        Item item = new Item("task1", "description1", System.currentTimeMillis());
        switch (position) {
            case ADDNEW:
                this.addNewTask(tracker, input);
                break;
            case SHOWALL:
                this.showAll(tracker);
                break;
            case EDIT:
                this.updTask(tracker,
                        input.ask("Enter the task ID you want to update: "),
                        new Item(input.ask("Task name? "),
                                input.ask("Task description? "),
                                System.currentTimeMillis()));
                break;
            case DEL:
                this.delTask(tracker, input.ask("Enter the task ID you want to DELETE: "));
                break;
            case IDFIND:
                this.idFind(tracker, input.ask("Input task Id: "));
                break;
            case NAMEFIND:
                this.nameFind(tracker, input.ask("Enter task name for search: "));
                break;
            case EXIT:
                System.out.println("Exit...");
            default:
                this.pos = 6;
                System.out.println("Exit...");
        }
    }

    /**
     * Обновление существующей заявки по ее id.
     *
     * @param tracker трекер.
     * @param id      - id заявки.
     */
    private void updTask(Tracker tracker, String id, Item itemNew) {
        Item item = tracker.findById(id);
        tracker.update(item, itemNew);
        System.out.println("Заявка с ID: " + item.getId() + " обновлена! Новые параметры заявки: ");
        this.idFind(tracker, id);
    }

    /**
     * Удаление заявки по id.
     *
     * @param tracker трекер.
     * @param id      - id заявки.
     */
    private void delTask(Tracker tracker, String id) {
        Item item = tracker.findById(id);
        tracker.delete(item);
        System.out.println("Заявка с ID: " + item.getId() + " удалена!");
    }

    /**
     * Поиск заявки по id.
     *
     * @param tracker трекер.
     * @param id      - id заявки.
     */
    private void idFind(Tracker tracker, String id) {
        Item item = tracker.findById(id);
        System.out.println("Найдена заявка с ID: " + item.getId() +
                " с названием " + item.name +
                " с дескриптором " + item.description + System.lineSeparator());
    }

    /**
     * Поиск заявки по имени.
     *
     * @param tracker трекер.
     * @param key     имя заявки для поиска.
     */
    private void nameFind(Tracker tracker, String key) {
        Item[] items = tracker.findByName(key);
        for (Item item : items) {
            System.out.println("Найдена заявка с ID: " + item.getId() +
                    " с названием " + item.name +
                    " с дескриптором " + item.description + System.lineSeparator());
        }
    }

    /**
     * Получение последнего номера позиции, которую выбрал пользователь.
     *
     * @return номер позиции.
     */
    public int getPos() {
        return pos;
    }

    /**
     * Добавление новой таски пользователем.
     *
     * @param tracker трекер.
     * @param input   тип ввода (коноль или тест).
     */
    private void addNewTask(Tracker tracker, Input input) {
        Item item = new Item(input.ask("Enter task name: "),
                input.ask("Enter task description: "),
                System.currentTimeMillis());
        tracker.add(item);
        System.out.println("Новая заявка: " + tracker.items[item.getIndex()].name + " создана" + System.lineSeparator());
    }

    /**
     * Выводит на экран все доступные трекера.
     *
     * @param tracker трекер.
     */
    private void showAll(Tracker tracker) {
        Item[] items = tracker.getAll();
        for (Item item : items) {
            System.out.println("Заявка с ID: " + item.getId() +
                    " с названием " + item.name +
                    " с дескриптором " + item.description);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        StartUI sui = new StartUI(input);
        Tracker tracker = new Tracker();
        sui.selectPosition();
//        sui.init();
        while (sui.getPos() >= 0 && sui.getPos() < 6) {
            System.out.println(new StringBuilder().append("Выбранная позиция: ").append(sui.getPos()).toString());
            sui.actionMenu(tracker, sui.getPos());
            sui.selectPosition();
        }
        System.out.println(new StringBuilder().append("Выбранная позиция: ").append(sui.getPos()).toString());
        System.out.println("Exit...");
        input.scannerClose();
    }
}
