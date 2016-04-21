package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private UserInterfaceSpy ui;
    private BoardSpy board;
    private Human player1;
    private Human player2;

    @Before
    public void setUp() {
        game = new Game();
        ui = new UserInterfaceSpy();
        board = new BoardSpy();
        player1 = new Human(X);
        player2 = new Human(O);
    }

    @Test
    public void canStartItself() {
        DumbComputer comp1 = new DumbComputer(X);
        DumbComputer comp2 = new DumbComputer(O);
        Board board = new Board();
        UserInterface newui = new UserInterface(new Scanner(""), new PrintStream(outContent));
        game.run(newui, board, comp1, comp2);
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        board.setADraw(true);
        game.run(ui, board, player1, player2);
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToWinCondition() {
        board.setHasAWinner(true);
        game.run(ui, board, player1, player2);
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        board.setADraw(true);
        game.run(ui, board, player1, player2);
        assertTrue(ui.wasAnnounceDrawCalled);
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        board.setHasAWinner(true);
        game.run(ui, board, player1, player2);
        assertTrue(ui.wasAnnounceWinCalled);
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        game.setUp(player1, player2);
        game.promptTurn(game.getCurrentPlayer(), board, ui);
        assertEquals(player2, game.getCurrentPlayer());
    }
}
