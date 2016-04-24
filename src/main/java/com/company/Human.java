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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        return mark == human.mark;

    }

    @Override
    public int hashCode() {
        return mark.hashCode();
    }
}

