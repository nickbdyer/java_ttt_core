package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;

public class GameTest {

    private Game game;
    private OutputStream outputStream;
    private DisplaySpy display;
    private BoardSpy board;

    @Before
    public void setUp() {
        game = new Game();
        outputStream = new ByteArrayOutputStream();
        display = new DisplaySpy(new Scanner(""), new PrintStream(outputStream));
        board = new BoardSpy();
    }

    @Test
    public void setsUpGame() {
        game.run(display, board);
        assertTrue(display.wasShowBoardCalled);
    }

    @Test
    public void gameLoopRuns() {
        game.run(display, board);
        assertTrue(display.wasShowBoardCalled);
        assertTrue(display.wasProcessMarkCalled);
    }
}