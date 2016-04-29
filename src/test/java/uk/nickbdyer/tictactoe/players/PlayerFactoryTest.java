package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Player;
import org.junit.Test;
import uk.nickbdyer.tictactoe.GameType;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlayerFactoryTest {

    @Test
    public void canCreateTwoHumanPlayers() {
        List<Player> players = new PlayerFactory().create(GameType.HvsH);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateAHumanAndComputerPlayer() {
        List<Player> players = new PlayerFactory().create(GameType.HvsAi);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory().create(GameType.AivsH);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoComputerPlayers() {
        List<Player> players = new PlayerFactory().create(GameType.AivsAi);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAHumanAndPerfectComputerPlayer() {
        List<Player> players = new PlayerFactory().create(GameType.HvsPAi);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }

    @Test
    public void canCreateAPerfectComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory().create(GameType.PAivsH);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoPerfectComputerPlayers() {
        List<Player> players = new PlayerFactory().create(GameType.PAivsPAi);
        assertTrue(players.get(0) instanceof DelayedComputer);
        assertTrue(players.get(1) instanceof DelayedComputer);
    }
}
