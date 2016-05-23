package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.delayers.MockDelayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static uk.nickbdyer.tictactoe.Mark.X;

public class DelayedComputerTest {

    private Board board;
    private MockDelayer delayer;

    @Before
    public void setUp() {
        board = new Board();
        delayer = new MockDelayer();
    }

    @Test
    public void hasMark() {
        DumbComputer dumbComputer = new DumbComputer(X);
        DelayedComputer delayedComputer = new DelayedComputer(dumbComputer, delayer, 0);
        assertEquals(X, delayedComputer.getMark());

    }

    @Test
    public void delaysDumbComputer() {
        DumbComputer dumbComputer = new DumbComputer(X);
        DelayedComputer delayedComputer = new DelayedComputer(dumbComputer, delayer, 0);
        delayedComputer.choosePosition(board);
        assertTrue(delayer.hasSleepBeenCalled);
    }

    @Test
    public void delaysPerfectComputer() {
        PerfectComputer perfectComputer = new PerfectComputer(X);
        DelayedComputer delayedComputer = new DelayedComputer(perfectComputer, delayer, 0);
        delayedComputer.choosePosition(board);
        assertTrue(delayer.hasSleepBeenCalled);
    }

}
