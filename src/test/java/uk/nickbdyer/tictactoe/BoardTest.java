package uk.nickbdyer.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.*;
import static uk.nickbdyer.tictactoe.Mark.*;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.createDrawnBoard;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.createEmptyBoard;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.setUpBoard;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void showsCurrentState() {
        assertEquals(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board.getCells());
    }

    @Test
    public void showsSpecificCellState() {
        createEmptyBoard(board);
        assertEquals(EMPTY, board.getMarkAt(0));
    }

    @Test
    public void marksWithX() {
        board.mark(3, X);
        assertEquals(X, board.getMarkAt(3));
    }

    @Test
    public void marksWithO() {
        board.mark(1, O);
        assertEquals(O, board.getMarkAt(1));
    }

    @Test
    public void knowsIfThereIsAXWinner() {
        setUpBoard(Arrays.asList(X, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, EMPTY, X), board);
        assertTrue(board.hasWinner());
        assertTrue(board.isUnplayable());
    }

    @Test
    public void knowsIfThereIsAOWinner() {
        setUpBoard(Arrays.asList(O, EMPTY, EMPTY, EMPTY, O, EMPTY, EMPTY, EMPTY, O), board);
        assertTrue(board.hasWinner());
    }

    @Test
    public void knowsIfThereIsNotAWinner() {
        board.mark(0, X);
        assertFalse(board.hasWinner());
    }

    @Test
    public void knowsIfItIsFull() {
        setUpBoard(Arrays.asList(O, X, O, X, O, X, O, X, O), board);
        assertTrue(board.isFull());
        assertFalse(board.isEmpty());
    }

    @Test
    public void knowsIfItIsNotFull() {
        setUpBoard(Arrays.asList(O, X, O, X, EMPTY, X, O, X, O), board);
        assertFalse(board.isFull());
        assertFalse(board.isEmpty());
    }

    @Test
    public void knowsIfItIsADraw() {
        createDrawnBoard(board);
        assertTrue(board.isDraw());
    }

    @Test
    public void knowsIfItIsNotADraw() {
        for(int i=0;i<9;i++) {
            board.mark(i, X);
        }
        assertFalse(board.isDraw());
    }

    @Test
    public void knowsIfXHasWon() {
        setUpBoard(Arrays.asList(X, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, EMPTY, X), board);
        assertEquals(X, board.getWinningMark());
    }

    @Test
    public void knowsIfOHasWon() {
        setUpBoard(Arrays.asList(O, EMPTY, EMPTY, EMPTY, O, EMPTY, EMPTY, EMPTY, O), board);
        assertEquals(O, board.getWinningMark());
    }

    @Test
    public void knowsIfBoardIsEmpty() {
        createEmptyBoard(board);
        assertTrue(board.isEmpty());
    }
}
