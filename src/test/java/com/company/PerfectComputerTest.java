package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.company.Mark.O;
import static com.company.Mark.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PerfectComputerTest {

    private PerfectComputer tron;
    private UserInterfaceSpy ui;
    private Board board;


    @Before
    public void setUp() {
        tron = new PerfectComputer(X);
        ui = new UserInterfaceSpy();
        board = new Board();
    }

    @Test
    public void willChooseACornerIfBoardIsEmpty() {
        assertTrue(Arrays.asList(0, 2, 6, 8).contains(tron.choosePosition(ui, board)));
    }
    
    @Test
    public void willBlockWinConditionFromOpponent() {
        board.mark(0, O);
        board.mark(3, X);
        board.mark(2, O);
        assertEquals(1, tron.choosePosition(ui, board));
    }

    @Test
    public void willPlayCenterIfFirstPlayerTookCorner() {
        board.mark(0, O);
        assertEquals(4, tron.choosePosition(ui, board));
    }

    @Test
    public void willWinGameIfOptionIsAvailable() {
        board.mark(0, X);
        board.mark(2, X);
        assertEquals(1, tron.choosePosition(ui, board));
    }

}
