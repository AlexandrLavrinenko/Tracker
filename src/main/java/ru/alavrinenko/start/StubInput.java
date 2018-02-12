package ru.alavrinenko.start;

/**
 * Класс для тестирования без участия консоли.
 */
public class StubInput implements Input{
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. пользователь  хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private final String[] answers;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    /**
     * Переопрелеляем конструктор.
     *
     * @param answers - строковый массив ответов.
     */
    public StubInput(final String[] answers) {
        this.answers = answers;
    }

    /**
     * Переопределенный метод ask - от интерфейса Input.
     *
     * @param question - массив строк-ответов.
     * @return строка ответа, согласно позиции position.
     */

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public void scannerClose() {
    }
}
