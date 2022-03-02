package ru.spbu.arts.java.oop.ascigraphics;

public class DrawCheck {

    public static void main(String[] args) {
        Drawing pic = new Drawing(30, 24, '⣿');

        pic.drawVerticalLine(2, 1, 22, '⠄');
        pic.drawVerticalLine(3, 1, 22, '⠄');
        pic.drawVerticalLine(27, 1, 22, '⠄');
        pic.drawVerticalLine(26, 1, 22, '⠄');
        pic.drawHorizontalLine(2, 27, 1, '⠄');
        pic.drawHorizontalLine(2, 27, 22, '⠄');

        pic.print();
        System.out.println();
    }
}