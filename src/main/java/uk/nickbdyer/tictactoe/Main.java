package uk.nickbdyer.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new Scanner(System.in), System.out);
        new GameEngine().start(ui);
    }
}