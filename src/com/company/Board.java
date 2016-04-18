package com.company;

import java.util.Arrays;
import java.util.List;

public class Board {

    private List<Character> cells;

    public Board() {
        this.cells = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
    }

    public List<Character> showCells() {
        return cells;
    }

    public char getMarkAt(int position) {
        return cells.get(position);
    }

    public void mark(int position, char mark) {
        cells.set(position, mark);
    }

    public boolean isCellEmpty(int position) {
        return Character.isDigit(cells.get(position));
    }

    public boolean hasAWinner() {
        return new Lines(cells).hasAWinner();
    }

    public boolean isFull() {
        for(int i=1;i<cells.size();i++) {
            if (isCellEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isADraw() {
        if (isFull() && !hasAWinner()) {
            return true;
        }
        return false;
    }

    public char getWinningMark() {
        return new Lines(cells).getWinningMark();
    }
}
