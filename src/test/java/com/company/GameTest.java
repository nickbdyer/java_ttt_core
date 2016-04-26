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

    @Before
    public void setUp() {
        game = new Game(new PlayerFactory().create(1));
        ui = new UserInterfaceSpy();
        board = new BoardSpy();
    }

    @Test
    public void canStartItself() {
        Game game = new Game(new PlayerFactory().create(3));
        Board board = new Board();
        UserInterface newui = new UserInterface(new Scanner(""), new PrintStream(outContent));
        game.play(newui, board);
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        board.setADraw(true);
        game.play(ui, board);
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToWinCondition() {
        board.setHasAWinner(true);
        game.play(ui, board);
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        board.setADraw(true);
        game.play(ui, board);
        assertTrue(ui.wasAnnounceDrawCalled);
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        board.setHasAWinner(true);
        game.play(ui, board);
        assertTrue(ui.wasAnnounceWinCalled);
    }

//    @Test
//    public void gameKnowsWhosTurnItIs() {
//        game.promptTurn(game.getCurrentPlayer(), board, ui);
//        assertEquals(player2, game.getCurrentPlayer());
//    }
}
