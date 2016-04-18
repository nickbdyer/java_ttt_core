package com.company;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private DisplaySpy display;
    private BoardSpy board;
    private Human player1;
    private Human player2;

    @Before
    public void setUp() {
        game = new Game();
        display = new DisplaySpy();
        board = new BoardSpy();
        player1 = new Human();
        player2 = new Human();
    }

//    @Test
//    public void canStartItself() {
//        game.run(display, board, player1, player2);
//        assertTrue(display.wasShowBoardCalled);
//        assertTrue(display.wasProcessMarkCalled);
//    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        board.setADraw(true);
        game.run(display, board, player1, player2);
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToWinCondition() {
        board.setHasAWinner(true);
        game.run(display, board, player1, player2);
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        board.setADraw(true);
        game.run(display, board, player1, player2);
        assertTrue(display.wasAnnounceDrawCalled);
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        board.setHasAWinner(true);
        game.run(display, board, player1, player2);
        assertTrue(display.wasAnnounceWinCalled);
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        game.setUp(player1, player2);
        game.promptTurn(game.getCurrentPlayer(), board, display);
        assertEquals(player2, game.getCurrentPlayer());
    }
}