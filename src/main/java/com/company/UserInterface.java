package com.company;

import java.io.PrintStream;
import java.util.Scanner;

import static com.company.GameType.HvsH;
import static com.company.Mark.EMPTY;

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

    public void displayBoard(Board board) {
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

    public GameType makeGameChoice() {
        displayGameChoiceMenu();
        for (GameType type : GameType.values()) {
            if (getGameChoice() == type.value) {
              return type;
            }
        }
        return HvsH;
    }

    private int getValidPosition(Board board) {
        int position;
        do {
            position = getNumber();
        } while (outOfBounds(board, position) || alreadyMarked(board, position));
        return position - 1;
    }

    private int getGameChoice() {
        int number;
        do {
            number = getNumber();
        } while (!validGameChoice(number));
        return number;
    }

    private int getNumber() {
        while (!input.hasNextInt()) {
            displayInvalidInput();
            input.next();
        }
        return input.nextInt();
    }

    private boolean outOfBounds(Board board, int number) {
        if (!isPositionInBounds(number, 1, board.getCells().size())) {
            displayInvalidPosition();
            return true;
        }
        return false;
    }

    private boolean alreadyMarked(Board board, int position) {
        if (!isPositionMarkable(position - 1, board)) {
            displayPositionOccupied();
            return true;
        }
        return false;
    }

    private boolean isPositionMarkable(int position, Board board) {
        return (board.isEmptyCell(position));
    }

    private boolean validGameChoice(int choice) {
        if (!isPositionInBounds(choice, 1, 2)) {
            displayInvalidSelection();
            return false;
        }
        return true;
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
        output.println("Please choose the game type:\n 1) Human vs Human \n 2) Human vs Computer");
    }

    public void displayInvalidInput() {
        output.println("That is not a valid input");
    }

    public void displayInvalidSelection() {
        output.println("That is not a valid selection");
    }

    public void displayInvalidPosition() {
        output.println("That is not a valid position");
    }

    public void displayPositionOccupied() {
        output.println("That cell is already marked, try again");
    }

    public void displayReplayQuery() {
        output.println("Would you like to play again (y/n)?");
    }
}
