package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.CLI;
import uk.nickbdyer.tictactoe.exceptions.InvalidGameTypeException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static uk.nickbdyer.tictactoe.GameType.*;

public class PlayerFactoryTest {

    private CLI ui;

    @Before
    public void setUp() {
        ui = new CLI(new Scanner(""), new PrintStream(new ByteArrayOutputStream()));
    }
    @Test
    public void canCreateTwoHumanPlayers() {
        List<Player> players = new PlayerFactory().create(HvsH, ui);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateAHumanAndComputerPlayer() {
        List<Player> players = new PlayerFactory().create(HvsAi, ui);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory().create(AivsH, ui);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoComputerPlayers() {
        List<Player> players = new PlayerFactory().create(AivsAi, ui);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAHumanAndPerfectComputerPlayer() {
        List<Player> players = new PlayerFactory().create(HvsPAi, ui);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAPerfectComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory().create(PAivsH, ui);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoPerfectComputerPlayers() {
        List<Player> players = new PlayerFactory().create(PAivsPAi, ui);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test(expected=InvalidGameTypeException.class)
    public void throwsExceptionIfBoardIsFull() {
        new PlayerFactory().create(TEST, ui);
    }

}
