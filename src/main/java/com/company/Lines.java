package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.company.Player.*;
import static com.company.Player.Mark.EMPTY;

class Lines {

    private ArrayList<Mark> cells;
    private Mark winningMark;

    public Lines(ArrayList<Mark> cells) {
        this.cells = cells;
    }

    protected List<List<Mark>> rows() {
        List<List<Mark>> rows = new ArrayList<>();
        List<Mark> row1 = cells.subList(0, 3);
        List<Mark> row2 = cells.subList(3, 6);
        List<Mark> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        return rows;
    }

    protected List<List<Mark>> columns() {
        return transpose(rows());
    }

    private <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<T>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }

    protected List<List<Mark>> diagonals() {
        List<List<Mark>> diagonals = new ArrayList<>();
        diagonals.add(leftDiagonal());
        diagonals.add(rightDiagonal());
        return diagonals;
    }

    private List<Mark> rightDiagonal() {
        List<List<Mark>> rows = new ArrayList<>();
        List<Mark> row1 = cells.subList(0, 3);
        List<Mark> row2 = cells.subList(3, 6);
        List<Mark> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        flipBoard(rows);

        List<Mark> right = new ArrayList<>();
        for(int i=0;i<3;i++) {
            right.add(rows.get(i).get(i));
        }
        flipBoard(rows);
        return right;
    }

    private void flipBoard(List<List<Mark>> rows) {
        for(int i=0;i<3;i++) {
            Collections.reverse(rows.get(i));
        }
    }

    private List<Mark> leftDiagonal() {
        List<List<Mark>> rows = new ArrayList<>();
        List<Mark> row1 = cells.subList(0, 3);
        List<Mark> row2 = cells.subList(3, 6);
        List<Mark> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        List<Mark> left = new ArrayList<>();
        for(int i=0;i<3;i++) {
            left.add(rows.get(i).get(i));
        }
        return left;
    }

    public List<List<Mark>> possibleCombinations() {
        List<List<Mark>> combinedList = new ArrayList<>();
        combinedList.addAll(rows());
        combinedList.addAll(columns());
        combinedList.addAll(diagonals());
        return combinedList;
    }

    public Mark getWinningMark() {
        lineExistsWithMatchingElements();
        return winningMark;
    }

    public boolean hasAWinner() {
        return lineExistsWithMatchingElements();
    }

    private boolean lineExistsWithMatchingElements() {
        for (List<Mark> line : possibleCombinations()) {
            if (hasAllMatchingElements(line)) {
                winningMark = line.get(0);
                return true;
            }
        }
        return false;
    }

    private boolean hasAllMatchingElements(List<Mark> array) {
        for(int i=1;i<array.size();i++) {
            if (array.get(0) != array.get(i) || array.get(0) == EMPTY) {
                return false;
            }
        }
        return true;
    }


}
