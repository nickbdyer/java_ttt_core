package com.company;

import java.util.Collections;
import java.util.List;

public class DumbComputer extends Player {

    @Override
    public void markBoard(UserInterface userInterface, Board board) {
        userInterface.displayComputerPlayingMessage();
        board.mark(generateMove(board.availableMoves()), getMark());
    }

     int generateMove(List<Integer> availableMoves) {
        Collections.shuffle(availableMoves);
        return availableMoves.get(0);
    }

}
