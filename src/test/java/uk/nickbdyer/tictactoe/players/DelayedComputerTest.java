package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.UserInterface;
import uk.nickbdyer.tictactoe.delayers.MockDelayer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static uk.nickbdyer.tictactoe.Mark.X;
import static org.junit.Assert.assertTrue;

public class DelayedComputerTest {

    @Test
    public void canDelayDumbComputerPlayer() {
        UserInterface ui = new UserInterface(new Scanner(""), new PrintStream(new ByteArrayOutputStream()));
        Board board = new Board();
        MockDelayer mockDelayer = new MockDelayer();
        DumbComputer dumbComputer = new DumbComputer(X);
        DelayedComputer delayedComputer = new DelayedComputer(dumbComputer,mockDelayer,0);
        delayedComputer.choosePosition(ui, board);
        assertTrue(mockDelayer.hasSleepBeenCalled);
    }

    @Test
    public void canDelayPerfectComputerPlayer() {
        UserInterface ui = new UserInterface(new Scanner(""), new PrintStream(new ByteArrayOutputStream()));
        Board board = new Board();
        MockDelayer mockDelayer = new MockDelayer();
        PerfectComputer perfectComputer = new PerfectComputer(X);
        DelayedComputer delayedComputer = new DelayedComputer(perfectComputer,mockDelayer,0);
        delayedComputer.choosePosition(ui, board);
        assertTrue(mockDelayer.hasSleepBeenCalled);
    }
}
