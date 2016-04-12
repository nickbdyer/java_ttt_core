package com.company;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameTest {

    private Game game;
    private DisplaySpy display;
    private BoardSpy board;

    @Before
    public void setUp() {
        game = new Game();
        display = new DisplaySpy();
        board = new BoardSpy();
    }

    @Test
    public void gameLoopRuns() {
        game.run(display, board);
        assertTrue(display.wasShowBoardCalled);
        assertTrue(display.wasProcessMarkCalled);
    }
}