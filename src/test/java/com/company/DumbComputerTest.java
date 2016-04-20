package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DumbComputerTest {

    @Test
    public void canGenerateValidMoveDecisionOnEmptyBoard() {
        DumbComputer hal9000 = new DumbComputer();
        Board board = new Board();
        assertTrue(board.isCellEmpty(hal9000.generateMove(board.availableMoves())));
    }

    @Test
    public void canGenerateValidMoveDecisionOnPartiallyFullBoard() {
        DumbComputer hal9000 = new DumbComputer();
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        for(int i=1;i<9;i++) {
            board.mark(i, 'X');
        }
        assertTrue(board.isCellEmpty(0));
        hal9000.markBoard(ui, board);
        assertFalse(board.isCellEmpty(0));
    }
}