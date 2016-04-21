package com.company;

import org.junit.Test;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DumbComputerTest {

    @Test
    public void canGenerateValidMoveDecisionOnPartiallyFullBoard() {
        DumbComputer hal9000 = new DumbComputer(O);
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        for(int i=1;i<9;i++) {
            board.mark(i, X);
        }
        assertTrue(board.isEmptyCell(0));
        hal9000.markBoard(ui, board);
        assertFalse(board.isEmptyCell(0));
    }
}