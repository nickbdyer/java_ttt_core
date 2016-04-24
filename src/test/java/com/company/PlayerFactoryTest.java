package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerFactoryTest {

    @Test
    public void canCreateTwoHumanPlayers() {
        PlayerFactory pfactory = new PlayerFactory();
        assertEquals(Arrays.asList(new Human(X), new Human(O)), pfactory.create(1));
    }

    @Test
    public void canCreateAHumanAndComputerPlayer() {
        PlayerFactory playerFactory = new PlayerFactory();
        assertEquals(Arrays.asList(new Human(X), new DumbComputer(O)), playerFactory.create(2));
    }
}
