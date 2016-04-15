package com.company;

public class Human extends Player {

    @Override
    public void markBoard(int position, Board board) {
        board.mark(position, getMark());
    }
}
