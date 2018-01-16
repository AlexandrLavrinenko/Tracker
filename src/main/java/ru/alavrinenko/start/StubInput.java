package ru.alavrinenko.start;
// класс из видео - доп.реализации не было
/**
 * Класс для тестирования без участия консоли.
 */
public class StubInput implements Input{
    private String[] answers;
    private int position = 0;

    /**
     * Переопрелеляем конструктор.
     *
     * @param answers - строковый массив ответов.
     */
    public StubInput(String[] answers) {
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
