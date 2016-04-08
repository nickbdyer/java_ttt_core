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
        int validatedNumber = getValidPosition(scanner, board);
        board.mark(validatedNumber, mark);
    }

    private int getValidPosition(Scanner scanner, Board board) {
        System.out.println("Please choose a number between 1-9");
        while (true) {
            int number = getNumber(scanner);
            if (checkNumberIsWithinBounds(number)) {
                if (checkNumberIsMarkable(number, board)) {
                    return number;
                } else {
                    System.out.println("That cell is already marked, try again");
                }
            } else {
                System.out.println("That is not a valid position");
            }
        }
    }

    private boolean checkNumberIsWithinBounds(int number) {
        return (number >= 1 && number <= 9);
    }

    private boolean checkNumberIsMarkable(int number, Board board) {
        return (board.isMarkable(number));
    }

    private int getNumber(Scanner scanner) {
        int number;
        while (!scanner.hasNextInt()) {
            System.out.println("That is not a valid input");
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }
}
