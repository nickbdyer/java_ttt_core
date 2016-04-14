package com.company;

public class Game {

    public void run(Display display, Board board) {
        Character mark = 'O';
        while (!isOver(board)) {
            mark = swapMarks(mark);
            display.showBoard(board);
            display.processMark(board, mark);

        }
        display.showBoard(board);
        announceGameOver(board, display);
    }

    private Character swapMarks(Character mark) {
        if (mark == 'O'){
            mark = 'X';
        } else {
            mark = 'O';
        }
        return mark;
    }

    private boolean isMarkNull(Character mark) {
        return mark == null;
    }

    public boolean isOver(Board board) {
        return (board.hasAWinner() || board.isADraw());
    }

    private void announceGameOver(Board board, Display display) {
        if (board.isADraw()) {
            display.announceDraw();
        } else if (board.hasAWinner()) {
            display.announceWinner(board);
        }
    }

}
