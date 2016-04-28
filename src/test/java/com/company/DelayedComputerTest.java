package com.company;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Mark.X;
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
