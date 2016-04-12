package com.company;

import java.util.Collections;

public class Board {

    private char[] cells;
    private int size;
    private int width;
    private char[][] rows;
    private char[][] columns;

    public Board() {
        this.cells = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        this.size = cells.length;
        this.width = (int) Math.sqrt(this.size);
        this.rows = rows();
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
        char[] row1 = new char[3];
        char[] row2 = new char[3];
        char[] row3 = new char[3];
        System.arraycopy(cells, 0, row1, 0, width);
        System.arraycopy(cells, 3, row2, 0, width);
        System.arraycopy(cells, 6, row3, 0, width);
        rows = new char[][]{row1, row2, row3};
        return rows;
    }

    public char[][] columns() {
        columns = new char[3][];
        System.arraycopy(rows, 0, columns, 0, 3);
//        Transpose array
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
        for(int i=0;i<3;i++) {
            int start = 0;
            int end = 2;
            char temp;
            while (start < end)
            {
                temp = rows[i][start];
                rows[i][start] = rows[i][end];
                rows[i][end] = temp;
                start++;
                end--;
            }
        }
        char[] right = new char[3];
        for(int i=0;i<3;i++) {
            right[i] = rows[i][i];
        }
        return right;
    }

    public char[] leftDiagonal() {
        char[] left = new char[3];
        for(int i=0;i<3;i++) {
            left[i] = rows[i][i];
        }
        return left;
    }

}
