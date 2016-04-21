package com.company;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;
import static org.junit.Assert.assertEquals;

public class HumanTest {

    @Test
    public void canRetrieveItsMark() {
        Human nick = new Human(X);
        assertEquals(X, nick.getMark());
    }

    @Test
    public void canMarkTheBoard() {
        Human nick = new Human(O);
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1"), new PrintStream(new ByteArrayOutputStream()));
        nick.markBoard(ui, board);
        assertEquals(O, board.getMarkAt(0));
    }


}
