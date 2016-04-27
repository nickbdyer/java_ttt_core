package com.company;

public class Human implements Player {

    private Mark mark;

    public Human(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(UserInterface ui, Board board) {
        ui.displayMoveInstructions();
        return ui.getNumber();
    }

    public Mark getMark() {
        return mark;
    }

}

