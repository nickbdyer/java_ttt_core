package com.company.players;

import com.company.Board;
import com.company.Mark;
import com.company.Player;
import com.company.UserInterface;

import java.util.Collections;
import java.util.List;

public class DumbComputer implements Player {

    private Mark mark;

    public DumbComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(UserInterface ui, Board board) {
        ui.displayComputerThinking();
        return generateMove(board.availableMoves());
    }

     private int generateMove(List<Integer> availableMoves) {
        Collections.shuffle(availableMoves);
         return availableMoves.get(0);
    }

    public Mark getMark() {
        return mark;
    }
}
