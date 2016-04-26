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
    public void canCreateTwoComputerPlayers() {
        List<Player> players = new PlayerFactory().create(AivsAi);
        assertTrue(players.get(0) instanceof DumbComputer);
        assertTrue(players.get(1) instanceof DumbComputer);
    }
}
