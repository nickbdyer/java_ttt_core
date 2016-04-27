package com.company;

import java.io.PrintStream;
import java.util.Scanner;

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

    public int getNumber() {
        while (!input.hasNextInt()) {
            displayInvalidInput();
            input.next();
        }
        return input.nextInt() - 1;
    }

    public GameType makeGameChoice() {
        displayGameChoiceMenu();
        return GameType.values()[getGameChoice()];
    }

    private int getGameChoice() {
        int number = getNumber();
        while (!validGameChoice(number)) {
            displayInvalidSelection();
            number = getNumber();
        }
        return number - 1;
    }

    private boolean validGameChoice(int choice) {
        return (choice >= 1 && choice <= GameType.values().length);
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
        clearScreen();
        output.println(liveboard);
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
        output.println("Please choose the game type:\n 1) Human vs Human \n 2) Human vs Computer \n 3) Computer vs Human \n 4) Computer vs Computer");
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

    public void displayReplayQuery() {
        output.println("Would you like to play again (y/n)?");
    }

    private void clearScreen() {
        output.print("\033[H\033[2J");
        output.flush();
    }
}
