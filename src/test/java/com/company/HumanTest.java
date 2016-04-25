package com.company;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
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
        nick.markBoard(ui, board);
        assertEquals(X, board.getMarkAt(0));
    }

}
