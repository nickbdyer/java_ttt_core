package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<Character> cells;
    private int size;
    private char winningMark;

    public Board() {
        this.cells = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        this.size = cells.size();
    }

    public char[] showCells() {
        char[] results = new char[9];
        for(int i=0;i<9;i++) {
            char cell = this.cells.get(i);
            results[i] = cell;
        }
        return results;
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

    public char[][] rows() {
        char[] row1char = new char[3];
        char[] row2char = new char[3];
        char[] row3char = new char[3];
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        for (int i=0;i<3;i++) {
            char cell1 = row1.get(i);
            char cell2 = row2.get(i);
            char cell3 = row3.get(i);
            row1char[i] = cell1;
            row2char[i] = cell2;
            row3char[i] = cell3;
        }
        return new char[][]{row1char, row2char, row3char};
    }

    public char[][] columns() {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        List<Character> row1 = cells.subList(0, 3);
        List<Character> row2 = cells.subList(3, 6);
        List<Character> row3 = cells.subList(6, 9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        List<List<Character>> columns = transpose(rows);

//        Convert to char[][] temporarily
        char[] col1char = new char[3];
        char[] col2char = new char[3];
        char[] col3char = new char[3];

        for (int i=0;i<3;i++) {
            char cell1 = columns.get(0).get(i);
            char cell2 = columns.get(1).get(i);
            char cell3 = columns.get(2).get(i);
            col1char[i] = cell1;
            col2char[i] = cell2;
            col3char[i] = cell3;
        }
        return new char[][]{col1char, col2char, col3char};
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


    public char[][] diagonals() {
        return new char[][]{leftDiagonal(), rightDiagonal()};
    }

    private char[] rightDiagonal() {
        char[][] rows = rows();
        flipBoard(rows);
        char[] right = new char[3];
        for(int i=0;i<3;i++) {
            right[i] = rows[i][i];
        }
        return right;
    }

    private void flipBoard(char[][] rows) {
        for(int i=0;i<3;i++) {
            reverseArray(rows[i]);
        }
    }

    private void reverseArray(char[] row) {
        int start = 0;
        int end = 2;
        char temp;
        while (start < end)
        {
            temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }

    private char[] leftDiagonal() {
        char[][] rows = rows();
        char[] left = new char[3];
        for(int i=0;i<3;i++) {
            left[i] = rows[i][i];
        }
        return left;
    }

    public char[][] possibleCombinations() {
        return concatenateArrays(rows(), columns(), diagonals());
    }

    private char[][] concatenateArrays(char[][] first, char[][]... rest) {
        int totalLength = first.length;
        for (char[][] array : rest) {
            totalLength += array.length;
        }
        char[][] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (char[][] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    public boolean hasAWinner() {
        for (char[] combo : possibleCombinations()) {
            if (hasAllMatchingElements(combo)) {
                winningMark = combo[0];
                return true;
            }
        }
        return false;
    }

    private boolean hasAllMatchingElements(char[] array) {
        for(int i=1;i<array.length;i++) {
            if (array[0] != array[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        for(int i=1;i<this.showCells().length;i++) {
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
