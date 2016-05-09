package uk.nickbdyer.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void showsCurrentState() {
        assertEquals(Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), board.getCells());
    }

    @Test
    public void showsSpecificCellState() {
        assertEquals(Mark.EMPTY, board.getMarkAt(0));
    }

    @Test
    public void marksWithX() {
        board.mark(3, Mark.X);
        assertEquals(Mark.X, board.getMarkAt(3));
    }

    @Test
    public void marksWithO() {
        board.mark(1, Mark.O);
        assertEquals(Mark.O, board.getMarkAt(1));
    }

    @Test
    public void knowsIfCellIsEmpty() {
        assertTrue(board.isEmptyCell(1));
    }

    @Test
    public void knowsIfCellIsNotEmpty() {
        board.mark(0, Mark.X);
        assertFalse(board.isEmptyCell(0));
    }

    @Test
    public void knowsIfThereIsAXWinner() {
        board.mark(0, Mark.X);
        board.mark(4, Mark.X);
        board.mark(8, Mark.X);
        assertTrue(board.hasWinner());
    }

    @Test
    public void knowsIfThereIsAOWinner() {
        board.mark(0, Mark.O);
        board.mark(4, Mark.O);
        board.mark(8, Mark.O);
        assertTrue(board.hasWinner());
    }

    @Test
    public void knowsIfThereIsNotAWinner() {
        board.mark(0, Mark.X);
        assertFalse(board.hasWinner());
    }

    @Test
    public void knowsIfItIsFull() {
        for(int i=0;i<9;i++) {
            board.mark(i, Mark.X);
        }
        assertTrue(board.isFull());
    }

    @Test
    public void knowsIfItIsNotFull() {
        for(int i=1;i<5;i++) {
            board.mark(i, Mark.X);
        }
        assertFalse(board.isFull());
    }

    @Test
    public void knowsIfItIsADraw() {
        createDrawCondition();
        assertTrue(board.isDraw());
    }

    @Test
    public void knowsIfItIsNotADraw() {
        for(int i=0;i<9;i++) {
            board.mark(i, Mark.X);
        }
        assertFalse(board.isDraw());
    }

    private void createDrawCondition() {
        board.mark(0, Mark.X);
        board.mark(1, Mark.X);
        board.mark(2, Mark.O);
        board.mark(3, Mark.O);
        board.mark(4, Mark.O);
        board.mark(5, Mark.X);
        board.mark(6, Mark.X);
        board.mark(7, Mark.O);
        board.mark(8, Mark.X);
    }

    @Test
    public void knowsIfXHasWon() {
        board.mark(0, Mark.X);
        board.mark(4, Mark.X);
        board.mark(8, Mark.X);
        assertEquals(Mark.X, board.getWinningMark());
    }

    @Test
    public void knowsIfOHasWon() {
        board.mark(0, Mark.O);
        board.mark(4, Mark.O);
        board.mark(8, Mark.O);
        assertEquals(Mark.O, board.getWinningMark());
    }

    @Test
    public void knowsIfBoardIsEmpty() {
        Board board = new Board();
        assertTrue(board.isEmpty());
    }
}
