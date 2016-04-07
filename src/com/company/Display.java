package com.company;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Display {

    private static final String BOARDTEMPLATE = " # | # | # \n"
            + "---|---|---\n"
            + " # | # | # \n"
            + "---|---|---\n"
            + " # | # | # ";


    public void showBoard(Board board) {
        String liveboard = BOARDTEMPLATE;
        for (int i = 0; i < 9; i++) {
            liveboard = liveboard.replaceFirst("#", Character.toString(board.showCells()[i]));
        }
        System.out.println(liveboard);
    }

    public void processMark(Scanner scanner, Board board, char mark) {
        int number;
        do {
            System.out.println("Please enter a number from 1-9");
            while (!scanner.hasNextInt()) {
                System.out.println("That is not a valid input");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number >= 9 && number <= 0);
        board.mark(number, mark);
    }
}
