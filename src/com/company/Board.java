package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private List<Character> cells;
    private int size;
    private char winningMark;

    public Board() {
        this.cells = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        this.size = cells.size();
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

    public List<List<Character>> rows() {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        return rows;
    }

    public List<List<Character>> columns() {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        List<List<Character>> columns = transpose(rows);

        return columns;
    }

    private static <T> List<List<T>> transpose(List<List<T>> table) {
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


    public List<List<Character>> diagonals() {
        List<List<Character>> diagonals = new ArrayList<List<Character>>();
        diagonals.add(leftDiagonal());
        diagonals.add(rightDiagonal());
        return diagonals;
    }

    private List<Character> rightDiagonal() {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        flipBoard(rows);

        List<Character> right = new ArrayList<Character>();
        for(int i=0;i<3;i++) {
            right.add(rows.get(i).get(i));
        }
        flipBoard(rows);
        return right;
    }

    private void flipBoard(List<List<Character>> rows) {
        for(int i=0;i<3;i++) {
            Collections.reverse(rows.get(i));
        }
    }

    private List<Character> leftDiagonal() {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        List<Character> left = new ArrayList<Character>();
        for(int i=0;i<3;i++) {
            left.add(rows.get(i).get(i));
        }
        return left;
    }

    public List<List<Character>> possibleCombinations() {
        List<List<Character>> combinedList = new ArrayList<List<Character>>();
        combinedList.addAll(rows());
        combinedList.addAll(columns());
        combinedList.addAll(diagonals());
        return combinedList;
    }


    public boolean hasAWinner() {
        for (List<Character> combo : possibleCombinations()) {
            if (hasAllMatchingElements(combo)) {
                winningMark = combo.get(0);
                return true;
            }
        }
        return false;
    }

    private boolean hasAllMatchingElements(List<Character> array) {
        for(int i=1;i<array.size();i++) {
            if (array.get(0) != array.get(i)) {
                return false;
            }
        }
        return true;
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
        hasAWinner();
        return winningMark;
    }
}
