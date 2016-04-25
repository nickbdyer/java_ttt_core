package com.company;

import com.company.Player.Mark;

import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Player.Mark.EMPTY;

public class UserInterface {

    private static final String BOARDTEMPLATE = " # | # | # \n"
                                              + "---|---|---\n"
                                              + " # | # | # \n"
                                              + "---|---|---\n"
                                              + " # | # | # \n";
    private final Scanner input;
    private final PrintStream output;

    public UserInterface(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public void showBoard(Board board) {
        String liveboard = BOARDTEMPLATE;
        for (int i = 0; i < 9; i++) {
            if (board.getCells().get(i) == EMPTY) {
                liveboard = liveboard.replaceFirst("#", Integer.toString(i + 1));
            } else {
                liveboard = liveboard.replaceFirst("#", String.valueOf(board.getCells().get(i)));
            }
        }
        output.println(liveboard);
    }

    public void makeMove(Board board, Mark mark) {
        displayMoveInstructions();
        board.mark(getValidPosition(board), mark);
    }

    public int makeGameChoice() {
        displayGameChoiceMenu();
        return getGameChoice();
    }

    private int getValidPosition(Board board) {
        while (true) {
            int position = getNumber();
            if (outOfBounds(board, position) || alreadyMarked(board, position))
                continue;
            return position - 1;
        }
    }

    private int getGameChoice() {
        while (true) {
            int number = getNumber();
            if (validGameChoice(number)) {
                continue;
            }
            return number;
        }
    }

    private int getNumber() {
        while (!input.hasNextInt()) {
            output.println("That is not a valid input");
            input.next();
        }
        return input.nextInt();
    }

    private boolean outOfBounds(Board board, int number) {
        if (!isPositionInBounds(number, 1, board.getCells().size())) {
            output.println("That is not a valid position");
            return true;
        }
        return false;
    }

    private boolean alreadyMarked(Board board, int number) {
        if (!isPositionMarkable(number - 1, board)) {
            output.println("That cell is already marked, try again");
            return true;
        }
        return false;
    }

    private boolean isPositionMarkable(int number, Board board) {
        return (board.isEmptyCell(number));
    }

    private boolean validGameChoice(int choice) {
        if (!isPositionInBounds(choice, 1, 2)) {
            output.println("That is not a valid selection");
            return true;
        }
        return false;
    }

    private boolean isPositionInBounds(int number, int lowerBound, int upperBound) {
        return (number >= lowerBound && number <= upperBound);
    }

    public void displayMoveInstructions() {
        output.println("Please choose a number between 1-9");
    }

    public void displayWinner(Board board) {
        String mark = String.valueOf(board.getWinningMark());
        output.println(mark + " has won!");
    }

    public void displayDraw() {
        output.println("It's a Draw!");
    }

    public void displayComputerThinking() {
        output.println("The computer player is thinking...");
    }

    public void displayGameChoiceMenu() {
        output.print("Please choose the game type:\n 1) Human vs Human \n 2) Human vs Computer");
    }

}
