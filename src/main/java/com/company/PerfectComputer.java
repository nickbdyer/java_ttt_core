package com.company;

public class PerfectComputer implements Player{

    private Mark mark;

    public PerfectComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(UserInterface userInterface, Board board) {
        return 1;
    }

    @Override
    public Mark getMark() {
        return mark;
    }
}
