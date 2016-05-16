package uk.nickbdyer.tictactoe;

import java.util.ArrayList;
import java.util.List;

import static uk.nickbdyer.tictactoe.Mark.EMPTY;

public class Board {

    private ArrayList<Mark> cells;

    public Board() {
        this.cells = new ArrayList<>();
        for (int i=0;i<9;i++) {
            this.cells.add(EMPTY);
        }
    }

    List<Mark> getCells() {
        return cells;
    }

    Mark getMarkAt(int position) {
        return cells.get(position);
    }

    public void mark(int position, Mark mark) {
        cells.set(position, mark);
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

    public boolean isUnplayable() {
        return isDraw() || hasWinner();
    }

    public boolean hasWinner() {
        return new Lines(cells).winner().isPresent();
    }

    public Mark getWinningMark() {
        if (hasWinner()) {
            return new Lines(cells).winner().get();
        }
        return EMPTY;
    }

    public boolean isDraw() {
        return isFull() && !hasWinner();
    }

    boolean isEmptyCell(int position) {
        return getMarkAt(position) == EMPTY;
    }

    public boolean isFull() {
        for(int i=1;i<cells.size();i++) {
            if (isEmptyCell(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return (availableMoves().size() == cells.size());
    }

}
