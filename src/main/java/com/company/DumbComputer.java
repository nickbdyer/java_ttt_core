package com.company;

import java.util.Collections;
import java.util.List;

public class DumbComputer implements Player {

    private char mark;

    public DumbComputer(char mark) {
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

    public char getMark() {
        return mark;
    }

}
