package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.exceptions.BoardUnplayableException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static uk.nickbdyer.tictactoe.Mark.*;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.createDrawnBoard;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.setUpBoard;

public class DumbComputerTest {

    private DumbComputer hal9000;
    private Board board;

    @Before
    public void setUp() {
        hal9000 = new DumbComputer(O);
        board = new Board();
    }

    @Test
    public void hasMark() {
        assertEquals(O, hal9000.getMark());
    }

    @Test
    public void returnsMoveChoice() {
        setUpBoard(Arrays.asList(X, X, O, X, X, O, O, O, EMPTY), board);
        assertEquals(8, hal9000.choosePosition(board));
    }

    @Test(expected=BoardUnplayableException.class)
    public void throwsExceptionIfBoardIsFull() {
        createDrawnBoard(board);
        hal9000.choosePosition(board);
    }

}