package com.company;

public class Human extends Player {

    @Override
    public void markBoard(UserInterface userInterface, Board board) {
        userInterface.processMark(board, getMark());
    }
}
