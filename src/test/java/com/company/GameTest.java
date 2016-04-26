package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        Game game = new Game(new PlayerFactory().create(1));
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1 2 4 5 7"), new PrintStream(outContent));
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        Game game = new Game(new PlayerFactory().create(1));
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1 2 4 5 8 7 3 6 9"), new PrintStream(outContent));
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        Game game = new Game(new PlayerFactory().create(1));
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1 2 4 5 8 7 3 6 9"), new PrintStream(outContent));
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.endGame(board,ui);
        assertThat(outContent.toString(), containsString("It's a Draw!"));
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        Game game = new Game(new PlayerFactory().create(1));
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1 2 4 5 7"), new PrintStream(outContent));
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.endGame(board,ui);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        Game game = new Game(new PlayerFactory().create(1));
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1 2 4 5 7"), new PrintStream(outContent));
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        game.promptTurn(board, ui);
        assertEquals(X, board.getMarkAt(0));
        assertEquals(O, board.getMarkAt(1));
    }
}
