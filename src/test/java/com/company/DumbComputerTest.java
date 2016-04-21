package com.company;

import org.junit.Before;
import org.junit.Test;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DumbComputerTest {

    private DumbComputer hal9000;

    @Before
    public void setUp() throws Exception {
        hal9000 = new DumbComputer(O);
    }

    @Test
    public void getsMark() {
        assertEquals(O, hal9000.getMark());
    }

    @Test
    public void marksOnlyFreeCellOnBoard() {
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        leaveOneBoardCellEmpty(board);

        hal9000.markBoard(ui, board);
        assertEquals(O, board.getMarkAt(0));
    }

    private void leaveOneBoardCellEmpty(Board board) {
        for(int i=1;i<9;i++) {
            board.mark(i, X);
        }
    }
}