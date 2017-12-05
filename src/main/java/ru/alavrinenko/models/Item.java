package ru.alavrinenko.models;

public class Item {
    public String name;         // Имя заявки
    public String description;  // Описание заявки
    public long create;         // Время создания заявки в миллисекундах
    private String id;          // id заявки
    private String[] comment;   // Комментарий к заявке
    private int index = 0;      // Порядковый номер элемента в массиве

    /**
     * Конструктор без параметров.
     */
    public Item() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param name        - имя.
     * @param description - описание.
     * @param create      - время создания в миллисекундах.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    // Геттеры и сеттеры id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Геттер имени заявки
    public String getName() {
        return name;
    }

    // Геттер описания заявки
    public String getDescription() {
        return description;
    }

    // Геттеры и сеттеры времени создания заявки

    /**
     * Метод устанавливает заданное время создания заявки.
     *
     * @param create - время в миллисекундах.
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * Метод устанавливает текущее время создания заявки в миллисекундах
     */
    public void setCreate() {
        this.create = System.currentTimeMillis();
    }

    public long getCreate() {
        return create;
    }

    // Геттеры и сеттеры комментария
    public String[] getComment() {
        return comment;
    }

    public void setComment(String[] comment) {
        this.comment = comment;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
