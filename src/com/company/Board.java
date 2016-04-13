package com.company;

import java.util.Arrays;

public class Board {

    private char[] cells;
    private int size;
    private int width;

    public Board() {
        this.cells = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        this.size = cells.length;
        this.width = (int) Math.sqrt(this.size);
    }

    public char[] showCells() {
        return cells;
    }

    public char getMarkAt(int position) {
        return cells[position - 1];
    }

    public void mark(int position, char mark) {
        cells[position - 1] = mark;
    }

    public boolean isCellEmpty(int position) {
        return Character.isDigit(cells[position - 1]);
    }

    public char[][] rows() {
        char[] row1 = Arrays.copyOfRange(cells, 0, 3);
        char[] row2 = Arrays.copyOfRange(cells, 3, 6);
        char[] row3 = Arrays.copyOfRange(cells, 6, 9);
        return new char[][]{row1, row2, row3};
    }

    public char[][] columns() {
        char[][] columns = new char[3][];
        System.arraycopy(rows(), 0, columns, 0, 3);
        return transpose2DArray(columns);
    }

    private char[][] transpose2DArray(char[][] columns) {
        for(int i=0;i<3;i++){
            for(int j=i+1;j<3;j++){
                columns[i][j] = (char) (columns[i][j] + columns[j][i]);
                columns[j][i] = (char) (columns[i][j] - columns[j][i]);
                columns[i][j] = (char) (columns[i][j] - columns[j][i]);
            }
        }
        return columns;
    }

    public char[][] diagonals() {
        return new char[][]{leftDiagonal(), rightDiagonal()};
    }

    public char[] rightDiagonal() {
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

    public char[] leftDiagonal() {
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

    public char[][] concatenateArrays(char[][] first, char[][]... rest) {
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
        return true;
    }

}
