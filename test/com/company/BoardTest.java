package com.company;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void canShowItsFullCurrentState() {
        assertArrayEquals(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }

    @Test
    public void canShowTheStateOfIndividualCell() {
        assertEquals('1', board.getMarkAt(1));
    }

    @Test
    public void canBeMarkedWithX() {
        board.mark(4, 'X');
        assertEquals('X', board.getMarkAt(4));
    }

    @Test
    public void canBeMarkedWithO() {
        board.mark(2, 'O');
        assertEquals('O', board.getMarkAt(2));
    }

    @Test
    public void knowsIfCellIsEmpty() {
        assertTrue(board.isCellEmpty(1));
    }

    @Test
    public void knowsIfCellIsNotEmpty() {
        board.mark(1, 'X');
        assertFalse(board.isCellEmpty(1));
    }

    @Test
    public void knowsItsRows() {
        board.mark(5, 'X');
        assertArrayEquals(new char[][]{{'1', '2', '3'}, {'4', 'X', '6',}, {'7', '8', '9'}}, board.rows());
    }

    @Test
    public void knowsItsColumns() {
        board.mark(5, 'X');
        assertArrayEquals(new char[][]{{'1', '4', '7'}, {'2', 'X', '8'}, {'3', '6', '9'}}, board.columns());
    }

    @Test
    public void knowsItsDiagonals() {
        board.mark(5, 'X');
        assertArrayEquals(new char[][]{{'1','X','9'}, {'3','X','7'}}, board.diagonals());
    }

    @Test
    public void knowsAllPossibleCombinations() {
        board.mark(5, 'X');
        assertArrayEquals(new char[][]{{'1', '2', '3'}, {'4', 'X', '6',}, {'7', '8', '9'}, {'1', '4', '7'}, {'2', 'X', '8'}, {'3', '6', '9'}, {'1', 'X', '9'}, {'3', 'X', '7'}}, board.possibleCombinations());
    }

    @Test
    public void knowsIfThereIsAWinner() {
        board.mark(1, 'X');
        board.mark(5, 'X');
        board.mark(9, 'X');
        assertTrue(board.hasAWinner());
    }

    @Test
    public void knowsIfThereIsNotAWinner() {
        board.mark(1, 'X');
        assertFalse(board.hasAWinner());
    }
}
