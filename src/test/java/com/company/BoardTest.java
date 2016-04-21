package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.company.Player.Mark.EMPTY;
import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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
    public void knowsIfCellIsEmpty() {
        assertTrue(board.isEmptyCell(1));
    }

    @Test
    public void knowsIfCellIsNotEmpty() {
        board.mark(0, X);
        assertFalse(board.isEmptyCell(0));
    }

    @Test
    public void knowsIfThereIsAXWinner() {
        board.mark(0, X);
        board.mark(4, X);
        board.mark(8, X);
        assertTrue(board.hasWinner());
    }

    @Test
    public void knowsIfThereIsAOWinner() {
        board.mark(0, O);
        board.mark(4, O);
        board.mark(8, O);
        assertTrue(board.hasWinner());
    }

    @Test
    public void knowsIfThereIsNotAWinner() {
        board.mark(0, X);
        assertFalse(board.hasWinner());
    }

    @Test
    public void knowsIfItIsFull() {
        for(int i=0;i<9;i++) {
            board.mark(i, X);
        }
        assertTrue(board.isFull());
    }

    @Test
    public void knowsIfItIsNotFull() {
        for(int i=1;i<5;i++) {
            board.mark(i, X);
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
            board.mark(i, X);
        }
        assertFalse(board.isDraw());
    }

    private void createDrawCondition() {
        board.mark(0, X);
        board.mark(1, X);
        board.mark(2, O);
        board.mark(3, O);
        board.mark(4, O);
        board.mark(5, X);
        board.mark(6, X);
        board.mark(7, O);
        board.mark(8, X);
    }

    @Test
    public void knowsIfXHasWon() {
        board.mark(0, X);
        board.mark(4, X);
        board.mark(8, X);
        assertEquals(X, board.getWinningMark());
    }

    @Test
    public void knowsIfOHasWon() {
        board.mark(0, O);
        board.mark(4, O);
        board.mark(8, O);
        assertEquals(O, board.getWinningMark());
    }
}
