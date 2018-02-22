package ru.alavrinenko.pseudo;

/**
 * @author Lavrinenko Aleksandr (alexandr.lavrinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++");
        pic.append(System.getProperty("line.separator"));
        pic.append("+   +");
        pic.append(System.getProperty("line.separator"));
        pic.append("+   +");
        pic.append(System.getProperty("line.separator"));
        pic.append("+   +");
        pic.append(System.getProperty("line.separator"));
        pic.append("+++++");
        return pic.toString();
    }
}
