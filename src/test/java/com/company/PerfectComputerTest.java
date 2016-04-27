package com.company;

import org.junit.Test;

import java.util.Arrays;

import static com.company.Mark.O;
import static com.company.Mark.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PerfectComputerTest {

    @Test
    public void willChooseACornerIfBoardIsEmpty() {
        PerfectComputer tron = new PerfectComputer(X);
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        assertTrue(Arrays.asList(0, 2, 6, 8).contains(tron.choosePosition(ui, board)));
    }
    
    @Test
    public void willBlockWinConditionFromOpponent() {
        PerfectComputer tron = new PerfectComputer(X);
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        board.mark(0, O);
        board.mark(3, X);
        board.mark(2, O);
        assertEquals(1, tron.choosePosition(ui, board));
    }
}
