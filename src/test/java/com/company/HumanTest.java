package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Mark.X;
import static org.junit.Assert.assertEquals;

public class HumanTest {

    private Human nick;

    @Before
    public void setUp() throws Exception {
        nick = new Human(X);
    }

    @Test
    public void canRetrieveItsMark() {
        assertEquals(X, nick.getMark());
    }

    @Test
    public void canMarkTheBoard() {
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1"), new PrintStream(new ByteArrayOutputStream()));
        assertEquals(1, nick.choosePosition(ui, board));
    }

}
