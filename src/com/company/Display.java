package com.company;

public class Display {

    private static final String BOARDTEMPLATE = " # | # | # \n"
            + "---|---|---\n"
            + " # | # | # \n"
            + "---|---|---\n"
            + " # | # | # ";


    public void showBoard(Board board) {
        String liveboard = BOARDTEMPLATE;
        for (int i = 0; i < 9; i++) {
            liveboard = liveboard.replaceFirst("#", Character.toString(board.showCells()[i]));
        }
        System.out.println(liveboard);
    }
}
