package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    @Test
    public void knowsItsMark() {
        Human nick = new Human();
        nick.setMark('X');
        assertEquals('X', nick.getMark());
    }
}
