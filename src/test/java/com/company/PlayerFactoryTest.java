package com.company;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayerFactoryTest {

    @Test
    public void canCreateTwoHumanPlayers() {
        PlayerFactory pfactory = new PlayerFactory();
        assertTrue(pfactory.create(1).get(0) instanceof Human);
        assertTrue(pfactory.create(1).get(1) instanceof Human);
    }

    @Test
    public void canCreateAHumanAndComputerPlayer() {
        PlayerFactory pfactory = new PlayerFactory();
        assertTrue(pfactory.create(2).get(0) instanceof Human);
        assertTrue(pfactory.create(2).get(1) instanceof DumbComputer);
    }
}
