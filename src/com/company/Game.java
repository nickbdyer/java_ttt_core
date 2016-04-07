package com.company;

import java.util.Scanner;

public class Game {

    public void run(Display display, Board board) {
        for (int i = 0; i < 5; i++) {
            display.showBoard(board);
            display.processMark(new Scanner(System.in), board, 'X');
            display.showBoard(board);
            display.processMark(new Scanner(System.in), board, 'O');
        }
    }

}
