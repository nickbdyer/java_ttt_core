package com.company;

import java.io.PrintStream;
import java.util.Scanner;

public class Display {

    private static final String BOARDTEMPLATE = " # | # | # \n"
                                              + "---|---|---\n"
                                              + " # | # | # \n"
                                              + "---|---|---\n"
                                              + " # | # | # ";
    private final Scanner input;
    private final PrintStream output;

    public Display(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public void showBoard(Board board) {
        String liveboard = BOARDTEMPLATE;
        for (int i = 0; i < 9; i++) {
            liveboard = liveboard.replaceFirst("#", Character.toString(board.showCells()[i]));
        }
        output.println(liveboard);
    }

    public void processMark(Board board, char mark) {
        int validatedNumber = getValidPosition(board);
        board.mark(validatedNumber, mark);
    }

    private int getValidPosition(Board board) {
       output.println("Please choose a number between 1-9");
        while (true) {
            int number = getNumber();
            if (checkNumberIsWithinBounds(number)) {
                if (checkNumberIsMarkable(number, board)) {
                    return number;
                } else {
                    output.println("That cell is already marked, try again");
                }
            } else {
                output.println("That is not a valid position");
            }
        }
    }

    private boolean checkNumberIsWithinBounds(int number) {
        return (number >= 1 && number <= 9);
    }

    private boolean checkNumberIsMarkable(int number, Board board) {
        return (board.isCellEmpty(number));
    }

    private int getNumber() {
        int number;
        while (!input.hasNextInt()) {
            output.println("That is not a valid input");
            input.next();
        }
        number = input.nextInt();
        return number;
    }
}
