package com.company;

import org.junit.Test;

import java.util.List;

import static com.company.GameType.*;
import static org.junit.Assert.assertTrue;

public class PlayerFactoryTest {

    @Test
    public void canCreateTwoHumanPlayers() {
        List<Player> players = new PlayerFactory().create(HvsH);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateAHumanAndComputerPlayer() {
        List<Player> players = new PlayerFactory().create(HvsAi);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof DumbComputer);
    }

    @Test
    public void canCreateAComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory().create(AivsH);
        assertTrue(players.get(0) instanceof DumbComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoComputerPlayers() {
        List<Player> players = new PlayerFactory().create(AivsAi);
        assertTrue(players.get(0) instanceof DumbComputer);
        assertTrue(players.get(1) instanceof DumbComputer);
    }

    @Test
    public void canCreateAHumanAndPerfectComputerPlayer() {
        List<Player> players = new PlayerFactory().create(HvsPAi);
        assertTrue(players.get(0) instanceof Human);
        assertTrue(players.get(1) instanceof PerfectComputer);
    }

    @Test
    public void canCreateAPerfectComputerAndHumanPlayer() {
        List<Player> players = new PlayerFactory().create(PAivsH);
        assertTrue(players.get(0) instanceof PerfectComputer);
        assertTrue(players.get(1) instanceof Human);
    }

    @Test
    public void canCreateTwoPerfectComputerPlayers() {
        List<Player> players = new PlayerFactory().create(PAivsPAi);
        assertTrue(players.get(0) instanceof PerfectComputer);
        assertTrue(players.get(1) instanceof PerfectComputer);
    }
}
