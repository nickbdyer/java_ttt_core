package com.company;

import org.junit.Ignore;
import org.junit.Test;

import static com.company.Player.Mark.X;
import static org.junit.Assert.assertEquals;

public class HumanTest {

    @Test
    public void canRetrieveItsMark() {
        Human nick = new Human(X);
        assertEquals(X, nick.getMark());
    }

//    @Ignore
//    @Test
//    public void canMarkTheBoard() {
//        Human nick = new Human();
//        Board board = new Board();
//        nick.setMark('X');
//        nick.markBoard(display, board);
//        assertEquals('X', board.getMarkAt(1));
//    }


}
