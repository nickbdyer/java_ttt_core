package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.company.Player.*;
import static com.company.Player.Mark.EMPTY;

class Lines {

    private ArrayList<Mark> cells;
    private int size;
    private int width;
    private Mark winningMark;

    public Lines(ArrayList<Mark> cells) {
        this.cells = cells;
        this.size = cells.size();
        this.width = (int) Math.sqrt(size);
    }

    public List<List<Mark>> possibleCombinations() {
        List<List<Mark>> combinedList = new ArrayList<>();
        combinedList.addAll(rows());
        combinedList.addAll(columns());
        combinedList.addAll(diagonals());
        return combinedList;
    }

    protected List<List<Mark>> rows() {
        List<List<Mark>> rows = new ArrayList<>();
        for (int i=0;i<3;i++) {
            rows.add(makeRow(i));
        }
        return rows;
    }

    private List<Mark> makeRow(int rowNumber) {
        int lowerBound = rowNumber * width;
        int upperBound = lowerBound + width;
        return cells.subList(lowerBound, upperBound);
    }

    protected List<List<Mark>> columns() {
        return transpose(rows());
    }

    private List<List<Mark>> transpose(List<List<Mark>> rows) {
        List<List<Mark>> columns = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            columns.add(makeColumn(rows, i));
        }
        return columns;
    }

    private List<Mark> makeColumn(List<List<Mark>> rows, int i) {
        List<Mark> column = new ArrayList<>();
        for (List<Mark> row : rows) {
            column.add(row.get(i));
        }
        return column;
    }

    protected List<List<Mark>> diagonals() {
        List<List<Mark>> diagonals = new ArrayList<>();
        diagonals.add(leftDiagonal());
        diagonals.add(rightDiagonal());
        return diagonals;
    }

    private List<Mark> leftDiagonal() {
        List<List<Mark>> rows = rows();

        List<Mark> leftDiagonal = new ArrayList<>();
        for(int i=0;i<width;i++) {
            leftDiagonal.add(rows.get(i).get(i));
        }
        return leftDiagonal;
    }

    private List<Mark> rightDiagonal() {
        List<List<Mark>> rows = rows();
        flipBoard(rows);

        List<Mark> right = new ArrayList<>();
        for(int i=0;i<width;i++) {
            right.add(rows.get(i).get(i));
        }
        return right;
    }

    private void flipBoard(List<List<Mark>> rows) {
        for(int i=0;i<width;i++) {
            Collections.reverse(rows.get(i));
        }
    }

    public Mark getWinningMark() {
        checkLinesForAllMatchingElements();
        return winningMark;
    }

    public boolean hasAWinner() {
        return checkLinesForAllMatchingElements();
    }

    private boolean checkLinesForAllMatchingElements() {
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
