package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new Scanner(System.in), System.out);
        new Game(new PlayerFactory().create(ui.makeGameChoice())).play(ui, new Board());
    }

}
