package uk.nickbdyer.tictactoe.helpers;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Mark;

import java.util.Arrays;
import java.util.List;

import static uk.nickbdyer.tictactoe.Mark.EMPTY;
import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;

public class BoardHelper {

    public static void createEmptyBoard(Board board) {
        setUpBoard(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board);
    }

    public static void createDrawnBoard(Board board) {
        setUpBoard(Arrays.asList(X, O, X, O, O, X, X, X, O), board);
    }

    public static void setUpBoard(List<Mark> marks, Board board) {
        for (int i = 0; i < 9; i++) {
            board.mark(i, marks.get(i));
        }
    }
}
