package uk.nickbdyer.tictactoe.players;

import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;

import static org.junit.Assert.assertEquals;
import static uk.nickbdyer.tictactoe.Mark.X;

public class HumanTest {

    @Test
    public void hasMark() {
        Human nick = new Human(X, new MockUI());
        assertEquals(X, nick.getMark());
    }

    @Test
    public void returnsMoveChoice() {
        Human nick = new Human(X, new MockUI());
        Board board = new Board();
        assertEquals(0, nick.choosePosition(board));
    }

    @Test
    public void marksBoard() {
        Human nick = new Human(X, new MockUI());
        Board board = new Board();
        nick.markBoard(board, nick.choosePosition(board));
        assertEquals(X, board.getMarkAt(0));
    }


}
