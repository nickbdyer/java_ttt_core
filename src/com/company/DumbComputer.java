package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DumbComputer extends Player {

    @Override
    public void markBoard(Display display, Board board) {
        board.mark(generateMove(board), getMark());
    }

    public int generateMove(Board board) {
        return selectRandom(determineAvailableMoves(board));
    }

    private List<Character> determineAvailableMoves(Board board) {
        List<Character> availableMoves = new ArrayList<Character>();
        for (Character cell : board.showCells()) {
            if (Character.isDigit(cell)) {
                availableMoves.add(cell);
            }
        }
        return availableMoves;
    }

    private int selectRandom(List<Character> availableMoves) {
        Collections.shuffle(availableMoves);
        return Character.getNumericValue(availableMoves.get(0)) - 1;
    }


}
