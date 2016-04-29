package com.company.players;

import com.company.Board;
import com.company.Mark;
import com.company.Player;
import com.company.UserInterface;

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

