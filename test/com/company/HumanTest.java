package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    @Test
    public void canRetrieveItsMark() {
        Human nick = new Human();
        nick.setMark('X');
        assertEquals('X', nick.getMark());
    }

    @Test
    public void canMarkTheBoard() {
        Human nick = new Human();
        Board board = new Board();
        nick.setMark('X');
        nick.markBoard(1, board);
        assertEquals('X', board.getMarkAt(1));
    }


}
