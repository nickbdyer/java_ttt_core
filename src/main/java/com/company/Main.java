package com.company;

import java.util.Scanner;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new Scanner(System.in), System.out);
        PlayerFactory playerFactory = new PlayerFactory();
        ui.showMenu();
        new Game(playerFactory.create(ui.getGameChoice())).play(ui, new Board());
    }

}
