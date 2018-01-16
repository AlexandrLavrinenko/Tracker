package ru.alavrinenko.start;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner sc = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        String result = sc.nextLine();
        return result;
    }

    /**
     * Закрываем поток.
     */
    public void scannerClose() {
        sc.close();
    }
}
