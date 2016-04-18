package com.company;

public abstract class Player {

    private char mark;

    public abstract void markBoard(Display display, Board board);

    public void setMark(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

}
