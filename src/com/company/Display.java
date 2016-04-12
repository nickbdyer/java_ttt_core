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
            if (!isPositionInBounds(number)) {
                output.println("That is not a valid position");
                continue;
            }
            if (!isPositionMarkable(number, board)) {
                output.println("That cell is already marked, try again");
                continue;
            }
            return number;
        }
    }

    private boolean isPositionInBounds(int number) {
        return (number >= 1 && number <= 9);
    }

    private boolean isPositionMarkable(int number, Board board) {
        return (board.isCellEmpty(number));
    }

    private int getNumber() {
        while (!input.hasNextInt()) {
            output.println("That is not a valid input");
            input.next();
        }
        return input.nextInt();
    }
}
