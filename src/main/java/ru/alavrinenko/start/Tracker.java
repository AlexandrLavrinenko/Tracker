package ru.alavrinenko.start;

import ru.alavrinenko.models.*;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    public Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position] = item;
        item.setIndex(this.position);
        this.position++;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание.
     * Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод возвращает копию массива this.items без null элементов
     *
     * @return this.items.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.items, 0, result, 0, this.position);
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     *
     * @param id
     * @return item.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     *
     * @param key - имя для поиска.
     * @return массив с результатами поиска.
     */
    public Item[] findByName(String key) {
        Item[] resultSearch = new Item[items.length];
        int resultId = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                resultSearch[resultId] = item;
                resultId++;
            }
        }
        Item[] result = new Item[resultId];
        System.arraycopy(resultSearch, 0, result, 0, resultId);
        return result;
    }

    /**
     * Метод удаляет ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id (id у Item можно получить с помощью метода getId).
     * Принимаем на вход один параметр Item, а не список полей.
     *
     * @param item - заявка.
     */
    public void delete(Item item) {
        Item[] itemsNew = new Item[items.length];
        int index = item.getIndex();
        System.arraycopy(items, 0, itemsNew, 0, index - 1);
        System.arraycopy(items, index, itemsNew, index - 1, items.length - index);
        items = itemsNew;
        this.position--;
    }

    /**
     * Метод меняет ячейку в массиве this.items.
     * Для этого находим ячейку в массиве по id (с помощью метода getId).
     * Принимаем на вход один параметр Item, а не список полей.
     *
     * @param item - заявка.
     */
    public void update(Item item) {
        String updId = item.getId();
        Item updItem = this.findById(updId);
        updItem.setId(item.getId());
        this.items[updItem.getIndex()] = item;
        this.items[updItem.getIndex()].setId(updId);
    }
}
