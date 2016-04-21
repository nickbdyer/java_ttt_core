package com.company;

import java.util.Collections;
import java.util.List;

public class DumbComputer implements Player {

    private Mark mark;

    public DumbComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public void markBoard(UserInterface userInterface, Board board) {
        userInterface.displayComputerPlayingMessage();
        board.mark(generateMove(board.availableMoves()), getMark());
    }

     private int generateMove(List<Integer> availableMoves) {
        Collections.shuffle(availableMoves);
        return availableMoves.get(0);
    }

    public Mark getMark() {
        return mark;
    }

}
