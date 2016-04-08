package com.company;

public class Board {

    private char[] cells;

    public Board() {
        this.cells = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void mark(int position, char mark) {
        cells[position - 1] = mark;
    }

    public char[] showCells() {
        return cells;
    }

    public boolean isMarkable(int position) {
        return Character.isDigit(cells[position - 1]);
    }
}
