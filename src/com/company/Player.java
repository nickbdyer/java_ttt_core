package com.company;

public abstract class Player {

    private Character mark;

    public abstract void markBoard(int position);

    public void setMark(Character mark) {
        this.mark = mark;
    }

    public Character getMark() {
        return mark;
    }

}
