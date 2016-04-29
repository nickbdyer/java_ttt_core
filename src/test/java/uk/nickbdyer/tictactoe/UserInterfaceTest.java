package uk.nickbdyer.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

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
        assertThat(outContent.toString(), containsString(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n\n"));
    }

    @Test
    public void willRejectNonDigitEntry() {
        createMockUserInput("g 1");
        userInterface.getNumber();
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
    }

    @Test
    public void willRejectNonYNEntry() {
        createMockUserInput("g 1 24 n");
        userInterface.getYorN();
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
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
        assertThat(outContent.toString(), containsString("Please choose the game type:\n 1) Human vs Human \n 2) Human vs Computer \n 3) Computer vs Human \n 4) Computer vs Computer \n 5) Human vs Perfect Computer \n 6) Perfect Computer vs Human \n 7) Perfect Computer vs Perfect Computer \n"));
    }

    @Test
    public void willValidateGameChoice() {
        createMockUserInput("9 h 1");
        userInterface.makeGameChoice();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
    }

    @Test
    public void willAskForReplay() {
        createMockUserInput("");
        userInterface.displayReplayQuery();
        assertThat(outContent.toString(), containsString("Would you like to play again (y/n)?"));

    }

    @Test
    public void willAnnounceRestart() {
        createMockUserInput("");
        userInterface.displayResetNotice();
        assertThat(outContent.toString(), containsString("Resetting game board!"));

    }
}
