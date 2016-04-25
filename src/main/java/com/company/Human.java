package com.company;

public class Human implements Player {

    private Mark mark;

    public Human(Mark mark) {
        this.mark = mark;
    }

    @Override
    public void markBoard(UserInterface ui, Board board) {
        ui.processMark(board, getMark());
    }

    public Mark getMark() {
        return mark;
    }

}

