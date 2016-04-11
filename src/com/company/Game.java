package com.company;

public class Game {

    public void run(Display display, Board board) {
        for (int i = 0; i < 5; i++) {
            display.showBoard(board);
            display.processMark(board, 'X');
            display.showBoard(board);
            display.processMark(board, 'O');
        }
    }

}
