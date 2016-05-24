package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.exceptions.BoardUnplayableException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static uk.nickbdyer.tictactoe.Mark.*;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.*;

public class PerfectComputerTest {

    private PerfectComputer tron;
    private Board board;

    @Before
    public void setUp() {
        tron = new PerfectComputer(X);
        board = new Board();
    }

    @Test
    public void hasMark() {
        assertEquals(X, tron.getMark());
    }

    @Test(expected=BoardUnplayableException.class)
    public void throwsExceptionIfBoardIsFull() {
        createDrawnBoard(board);
        tron.choosePosition(board);
    }

    @Test
    public void marksBoard() {
        tron.markBoard(board, 0);
        assertEquals(X, board.getMarkAt(0));
    }

    @Test
    public void willChooseACornerIfBoardIsEmpty() {
        createEmptyBoard(board);
        assertTrue(Arrays.asList(0, 2, 6, 8).contains(tron.choosePosition(board)));
    }
    
    @Test
    public void willPlayCenterIfFirstPlayerTookCorner() {
        setUpBoard(Arrays.asList(O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board);
        assertEquals(4, tron.choosePosition(board));
    }

    @Test
    public void willWinGameIfOptionIsAvailable() {
        setUpBoard(Arrays.asList(X, EMPTY, X, O, O, EMPTY, EMPTY, EMPTY, EMPTY), board);
        assertEquals(1, tron.choosePosition(board));
    }

    @Test
    public void willStopGameWinIfOptionIsAvailable() {
        setUpBoard(Arrays.asList(EMPTY, O, EMPTY, EMPTY, EMPTY, O, X, X, O), board);
        assertEquals(2, tron.choosePosition(board));
    }

    @Test
    public void willPreventDiagonalFork() {
        setUpBoard(Arrays.asList(X, EMPTY, EMPTY, EMPTY, O, EMPTY, EMPTY, EMPTY, O), board);
        assertEquals(2, tron.choosePosition(board));
    }

    @Test
    public void willPreventAlternateDiagonalFork() {
        setUpBoard(Arrays.asList(O, EMPTY, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, O), board);
        assertEquals(4, tron.choosePosition(board));
    }

    @Test
    public void willPreventEdgeTrap() {
        setUpBoard(Arrays.asList(EMPTY, O, EMPTY, O, X, EMPTY, EMPTY, EMPTY, EMPTY), board);
        assertEquals(0, tron.choosePosition(board));
    }

    @Test
    public void willPreventReverseEdgeTrap() {
        setUpBoard(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, X, O, EMPTY, O, EMPTY), board);
        assertEquals(2, tron.choosePosition(board));
    }

}
