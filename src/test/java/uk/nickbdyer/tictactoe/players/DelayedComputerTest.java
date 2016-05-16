package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Delayer;
import uk.nickbdyer.tictactoe.UserInterface;
import uk.nickbdyer.tictactoe.delayers.MockDelayer;
import uk.nickbdyer.tictactoe.delayers.ThreadDelayer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static uk.nickbdyer.tictactoe.Mark.X;

public class DelayedComputerTest {

    private UserInterface ui;
    private Board board;
    private MockDelayer delayer;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        ui = new UserInterface(new Scanner(""), new PrintStream(outContent));
        board = new Board();
        delayer = new MockDelayer();
    }

    @Test
    public void hasMark() {
        DumbComputer dumbComputer = new DumbComputer(X, ui);
        DelayedComputer delayedComputer = new DelayedComputer(dumbComputer, delayer, 0);
        assertEquals(X, delayedComputer.getMark());

    }

    @Test
    public void delaysDumbComputer() {
        DumbComputer dumbComputer = new DumbComputer(X, ui);
        DelayedComputer delayedComputer = new DelayedComputer(dumbComputer, delayer, 0);
        delayedComputer.choosePosition(board);
        assertTrue(delayer.hasSleepBeenCalled);
    }

    @Test
    public void delaysPerfectComputer() {
        PerfectComputer perfectComputer = new PerfectComputer(X, ui);
        DelayedComputer delayedComputer = new DelayedComputer(perfectComputer, delayer, 0);
        delayedComputer.choosePosition(board);
        assertTrue(delayer.hasSleepBeenCalled);
    }

    @Test
    public void productionDelayRuns() {
        Delayer delayer = new ThreadDelayer();
        DumbComputer dumbComputer = new DumbComputer(X, ui);
        DelayedComputer delayedComputer = new DelayedComputer(dumbComputer, delayer, 0);
        delayedComputer.choosePosition(board);
        assertThat(outContent.toString(), containsString("The computer player is thinking"));
    }
}
