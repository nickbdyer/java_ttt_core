package com.company;

public class Display {

    private static final String BOARD = " 1 | 2 | 3 \n"
            + "---|---|---\n"
            + " 4 | 5 | 6 \n"
            + "---|---|---\n"
            + " 7 | 8 | 9 ";



    public void showBoard(Board board) {
        System.out.println(BOARD);
    }
}
