package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Lines {

    private List<Character> cells;

    public Lines(List<Character> cells) {
        this.cells = cells;
    }

    protected List<List<Character>> rows() {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        return rows;
    }

    protected List<List<Character>> columns() {
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

    protected List<List<Character>> diagonals() {
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

}
