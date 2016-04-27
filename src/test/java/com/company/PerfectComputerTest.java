package com.company;

import org.junit.Test;

import java.util.Arrays;

import static com.company.Mark.X;
import static org.junit.Assert.assertTrue;

public class PerfectComputerTest {

    @Test
    public void willChooseACornerIfBoardIsEmpty() {
        PerfectComputer tron = new PerfectComputer(X);
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        assertTrue(Arrays.asList(1, 3, 7, 9).contains(tron.choosePosition(ui, board)));
    }
}
