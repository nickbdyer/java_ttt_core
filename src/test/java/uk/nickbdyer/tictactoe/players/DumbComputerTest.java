package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.UserInterfaceSpy;
import uk.nickbdyer.tictactoe.exceptions.InvalidMoveException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static uk.nickbdyer.tictactoe.Mark.*;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.createDrawnBoard;
import static uk.nickbdyer.tictactoe.helpers.BoardHelper.setUpBoard;

public class DumbComputerTest {

    private DumbComputer hal9000;

    @Before
    public void setUp() {
        hal9000 = new DumbComputer(O);
    }

    @Test
    public void hasMark() {
        assertEquals(O, hal9000.getMark());
    }

    @Test
    public void returnsMoveChoice() {
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        setUpBoard(Arrays.asList(X, X, O, X, X, O, O, O, EMPTY), board);
        assertEquals(8, hal9000.choosePosition(ui, board));
    }

    @Test(expected=InvalidMoveException.class)
    public void throwsExceptionIfBoardIsFull() {
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        createDrawnBoard(board);
        hal9000.choosePosition(ui, board);
    }

}