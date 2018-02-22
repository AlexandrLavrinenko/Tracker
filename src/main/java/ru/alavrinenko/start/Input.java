package ru.alavrinenko.start;

/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    String ask(String question);
    void  scannerClose();
}
