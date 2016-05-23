package uk.nickbdyer.tictactoe.players;

import org.junit.Test;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.exceptions.InvalidGameTypeException;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static uk.nickbdyer.tictactoe.GameType.*;

public class PlayerFactoryTest {

    @Test
    public void canCreateTwoHumanPlayers() {
        List<Player> players = new PlayerFactory(new MockUI()).create(HvsH);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateAHumanAndComputerPlayer() {
        List<Player> players = new PlayerFactory(new MockUI()).create(HvsAi);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory(new MockUI()).create(AivsH);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoComputerPlayers() {
        List<Player> players = new PlayerFactory(new MockUI()).create(AivsAi);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAHumanAndPerfectComputerPlayer() {
        List<Player> players = new PlayerFactory(new MockUI()).create(HvsPAi);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAPerfectComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory(new MockUI()).create(PAivsH);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoPerfectComputerPlayers() {
        List<Player> players = new PlayerFactory(new MockUI()).create(PAivsPAi);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test(expected=InvalidGameTypeException.class)
    public void throwsExceptionIfBoardIsFull() {
        new PlayerFactory(new MockUI()).create(TEST);
    }

}
