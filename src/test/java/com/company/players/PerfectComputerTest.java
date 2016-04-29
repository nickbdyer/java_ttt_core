package com.company.players;

import com.company.Board;
import com.company.Mark;
import com.company.UserInterfaceSpy;
import com.company.players.PerfectComputer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.company.Mark.EMPTY;
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
    public void willPlayCenterIfFirstPlayerTookCorner() {
        setUpBoard(Arrays.asList(O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board);
        assertEquals(4, tron.choosePosition(ui, board));
    }

    @Test
    public void willWinGameIfOptionIsAvailable() {
        setUpBoard(Arrays.asList(X, EMPTY, X, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board);
        assertEquals(1, tron.choosePosition(ui, board));
    }

    @Test
    public void willStopGameWinIfOptionIsAvailable() {
        setUpBoard(Arrays.asList(EMPTY, O, EMPTY, EMPTY, EMPTY, O, X, X, O), board);
        assertEquals(2, tron.choosePosition(ui, board));
    }

    @Test
    public void willPreventDiagonalFork() {
        setUpBoard(Arrays.asList(X, EMPTY, EMPTY, EMPTY, O, EMPTY, EMPTY, EMPTY, O), board);
        assertEquals(2, tron.choosePosition(ui, board));
    }

    @Test
    public void willPreventAlternateDiagonalFork() {
        setUpBoard(Arrays.asList(O, EMPTY, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, O), board);
        assertEquals(4, tron.choosePosition(ui, board));
    }

    @Test
    public void willPreventEdgeTrap() {
        setUpBoard(Arrays.asList(EMPTY, O, EMPTY, O, X, EMPTY, EMPTY, EMPTY, EMPTY), board);
        assertEquals(0, tron.choosePosition(ui, board));
    }

    @Test
    public void willPreventReverseEdgeTrap() {
        setUpBoard(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, X, O, EMPTY, O, EMPTY), board);
        assertEquals(2, tron.choosePosition(ui, board));
    }

    private void setUpBoard(List<Mark> marks, Board board) {
        for (int i=0;i<9;i++) {
            board.mark(i, marks.get(i));
        }
    }

}
