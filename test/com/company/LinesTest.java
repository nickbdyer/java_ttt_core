package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LinesTest {

    private Lines lines;

    @Before
    public void setUp() throws Exception {
        lines = new Lines(Arrays.asList('1', '2', '3', '4', 'X', '6', '7', '8', '9'));
    }

    @Test
    public void knowsItsRows() {
        assertEquals(Arrays.asList(Arrays.asList('1', '2', '3'), Arrays.asList('4', 'X', '6'), Arrays.asList('7', '8', '9')), lines.rows());
    }

    @Test
    public void knowsItsColumns() {
        assertEquals(Arrays.asList(Arrays.asList('1', '4', '7'), Arrays.asList('2', 'X', '8'), Arrays.asList('3', '6', '9')), lines.columns());
    }

    @Test
    public void knowsItsDiagonals() {
        assertEquals(Arrays.asList(Arrays.asList('1','X','9'), Arrays.asList('3','X','7')), lines.diagonals());
    }

    @Test
    public void knowsAllPossibleCombinations() {
        assertEquals(Arrays.asList(Arrays.asList('1', '2', '3'), Arrays.asList('4', 'X', '6'), Arrays.asList('7', '8', '9'), Arrays.asList('1', '4', '7'), Arrays.asList('2', 'X', '8'), Arrays.asList('3', '6', '9'), Arrays.asList('1', 'X', '9'), Arrays.asList('3', 'X', '7')), lines.possibleCombinations());
    }

}
