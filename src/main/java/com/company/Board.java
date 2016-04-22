package com.company;

import com.company.Player.Mark;

import java.util.ArrayList;
import java.util.List;

import static com.company.Player.Mark.EMPTY;

public class Board {

    private ArrayList<Mark> cells;

    public Board() {
        this.cells = new ArrayList<>();
        for (int i=0;i<9;i++) {
            this.cells.add(EMPTY);
        }
    }

    public List<Mark> getCells() {
        return cells;
    }

    public Mark getMarkAt(int position) {
        return cells.get(position);
    }

    public void mark(int position, Mark mark) {
        cells.set(position, mark);
    }

    public boolean isEmptyCell(int position) {
        return cells.get(position) == EMPTY;
    }

    public boolean hasWinner() {
        return new Lines(cells).hasAWinner();
    }

    public Mark getWinningMark() {
        return new Lines(cells).getWinningMark();
    }

    public boolean isFull() {
        for(int i=1;i<cells.size();i++) {
            if (isEmptyCell(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDraw() {
        if (isFull() && !hasWinner()) {
            return true;
        }
        return false;
    }

    public List<Integer> availableMoves() {
        List<Integer> availableMoves = new ArrayList<>();
        for (int i=0;i<cells.size();i++) {
            if (isEmptyCell(i)) {
                availableMoves.add(i);
            }
        }
        return availableMoves;
    }
}
