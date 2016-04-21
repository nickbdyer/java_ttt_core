package com.company;

public class Human implements Player {

    private char mark;

    public Human(char mark) {
        this.mark = mark;
    }

    @Override
    public void markBoard(UserInterface userInterface, Board board) {
        userInterface.processMark(board, getMark());
    }

    public char getMark() {
        return mark;
    }
}

