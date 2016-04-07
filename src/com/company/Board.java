package com.company;

public class Board {

    private char[] cells;

    public Board() {
        this.cells = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

//    public void mark(int position) {
//        cells[position - 1] = 'X';
//    }

    public char[] showCells() {
        return cells;
    }
}
