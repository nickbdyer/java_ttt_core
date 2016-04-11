package com.company;

import com.company.Board;
import org.junit.Before;
import org.junit.Test;

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
    public void boardIsGenerated() {
        assertArrayEquals(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }

    @Test
    public void boardCanBeMarkedWithX() {
        board.mark(4, 'X');
        assertArrayEquals(new char[]{'1', '2', '3', 'X', '5', '6', '7', '8', '9'}, board.showCells());
    }

    @Test
    public void boardCanBeMarkedWithO() {
        board.mark(2, 'O');
        assertArrayEquals(new char[]{'1', 'O', '3', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }

    @Test
    public void boardKnowsIfCellIsMarked() {
        board.mark(1, 'X');
        assertFalse(board.isCellEmpty(1));
        assertTrue(board.isCellEmpty(2));
    }

    @Test
    public void boardKnowsIfCellIsNotMarked() {
        assertTrue(board.isCellEmpty(1));
    }
}
