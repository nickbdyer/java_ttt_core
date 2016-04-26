package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.GameType.HvsH;
import static com.company.Mark.O;
import static com.company.Mark.X;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Board board;
    private UserInterface ui;

    @Before
    public void setUp() {
        game = new Game(new PlayerFactory().create(HvsH));
        board = new Board();
    }

    @Test
    public void canStartItself() {
        makeMultipleMoves(5, "1 2 4 5 7");
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        makeMultipleMoves(9, "1 2 4 5 8 7 3 6 9");
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        makeMultipleMoves(9, "1 2 4 5 8 7 3 6 9");
        game.endGame(board,ui);
        assertThat(outContent.toString(), containsString("It's a Draw!"));
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        makeMultipleMoves(5, "1 2 4 5 7");
        game.endGame(board,ui);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        makeMultipleMoves(5, "1 2 4 5 7");
        assertEquals(X, board.getMarkAt(0));
        assertEquals(O, board.getMarkAt(1));
    }

    private void makeMultipleMoves(int numberOfMoves, String positions) {
        ui = new UserInterface(new Scanner(positions), new PrintStream(outContent));
        for (int i=0;i<numberOfMoves;i++) {
            game.promptTurn(board, ui);
        }
    }
}
