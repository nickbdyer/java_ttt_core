package com.company;

import com.company.Player.Mark;

import java.util.ArrayList;
import java.util.List;

import static com.company.Player.Mark.EMPTY;

public class Board {

    private ArrayList<Mark> cells;

    public Board() {
        this.cells = new ArrayList<Mark>();
        for (int i=0;i<9;i++) {
            this.cells.add(EMPTY);
        }
    }

    public List<Mark> showCells() {
        return cells;
    }

    public Mark getMarkAt(int position) {
        return cells.get(position);
    }

    public void mark(int position, Mark mark) {
        cells.set(position, mark);
    }

    public boolean isCellEmpty(int position) {
        return cells.get(position) == EMPTY;
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

    public Mark getWinningMark() {
        return new Lines(cells).getWinningMark();
    }

    public List<Integer> availableMoves() {
        List<Integer> availableMoves = new ArrayList<Integer>();
        for (int i=0;i<cells.size();i++) {
            if (isCellEmpty(i)) {
                availableMoves.add(i);
            }
        }
        return availableMoves;
    }
}
