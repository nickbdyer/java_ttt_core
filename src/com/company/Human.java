package com.company;

public class Human extends Player {

    @Override
    public void markBoard(Display display, Board board) {
        display.processMark(board, getMark());
    }
}
