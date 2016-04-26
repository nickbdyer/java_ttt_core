package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import static com.company.Mark.*;

public class UserInterfaceTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Board board;
    private UserInterface userInterface;
    private Scanner sc;

    @Before
    public void setUp() {
        board = new Board();
    }

    private void createMockUserInput(String input) {
        sc = new Scanner(input);
        userInterface = new UserInterface(sc, new PrintStream(outContent));
    }

    @Test
    public void showBoard() {
        createMockUserInput("");
        userInterface.displayBoard(board);
        sc.close();
        assertEquals(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n\n", outContent.toString());
    }

    @Test
    public void canProcessMark() {
        BoardSpy board = new BoardSpy();
        createMockUserInput("1");
        userInterface.makeMove(board, X);
        sc.close();
        assertTrue(board.wasMarkCalled);
    }

    @Test
    public void willRejectNonDigitEntry() {
        createMockUserInput("g 1");
        userInterface.makeMove(board, X);
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
        assertEquals(Arrays.asList(X, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board.getCells());
    }

    @Test
    public void willRejectOutOfBoundsEntry() {
        createMockUserInput("23 5");
        userInterface.makeMove(board, X);
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid position"));
        assertEquals(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, EMPTY, EMPTY), board.getCells());
    }

    @Test
    public void willNotAllowAMarkedCellToBeMarked() {
        Board board = new Board();
        createMockUserInput("1 1 2");
        userInterface.makeMove(board, X);
        userInterface.makeMove(board, O);
        sc.close();
        assertThat(outContent.toString(), containsString("That cell is already marked, try again"));
        assertEquals(Arrays.asList(X, O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY), board.getCells());
    }

    @Test
    public void willShowWinningMessageX() {
        Board board = new Board();
        createMockUserInput("1 4 2 5 3");
        userInterface.makeMove(board, X);
        userInterface.makeMove(board, O);
        userInterface.makeMove(board, X);
        userInterface.makeMove(board, O);
        userInterface.makeMove(board, X);
        sc.close();
        userInterface.displayWinner(board);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void willShowWinningMessageO() {
        Board board = new Board();
        createMockUserInput("1 4 2 5 3");
        userInterface.makeMove(board, O);
        userInterface.makeMove(board, X);
        userInterface.makeMove(board, O);
        userInterface.makeMove(board, X);
        userInterface.makeMove(board, O);
        sc.close();
        userInterface.displayWinner(board);
        assertThat(outContent.toString(), containsString("O has won!"));
    }

    @Test
    public void willShowDrawMessage() {
        createMockUserInput("");
        userInterface.displayDraw();
        assertThat(outContent.toString(), containsString("It's a Draw!"));
    }

    @Test
    public void willShowComputerPlayingMessage() {
        createMockUserInput("");
        userInterface.displayComputerThinking();
        assertThat(outContent.toString(), containsString("The computer player is thinking..."));
    }

    @Test
    public void willShowGameTypeOptions() {
        createMockUserInput("");
        userInterface.displayGameChoiceMenu();
        assertThat(outContent.toString(), containsString("Please choose the game type:\n 1) Human vs Human \n 2) Human vs Computer"));
    }

    @Test
    public void willValidateGameChoice() {
        createMockUserInput("7 h 1");
        userInterface.makeGameChoice();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
    }

    @Test
    public void willAskForReplay() {
        createMockUserInput("");
        userInterface.displayReplayQuery();
        assertThat(outContent.toString(), containsString("Would you like to play again (y/n)?"));

    }
}
