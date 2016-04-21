package com.company;

import java.util.Scanner;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;

public class Main {

    public static void main(String[] args) {
        new Game().run(new UserInterface(new Scanner(System.in), System.out), new Board(), new Human(X), new DumbComputer(O));
    }

}
