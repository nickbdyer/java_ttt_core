package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.company.Player.*;
import static com.company.Player.Mark.*;
import static com.company.Player.Mark.EMPTY;
import static junit.framework.TestCase.assertEquals;

public class LinesTest {

    private Lines lines;

    @Before
    public void setUp() throws Exception {
        lines = new Lines(new ArrayList<Mark>(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, X, EMPTY, EMPTY, EMPTY, EMPTY)));
    }

    @Test
    public void knowsItsRows() {
        assertEquals(Arrays.asList(Arrays.asList(EMPTY, EMPTY, EMPTY), Arrays.asList(EMPTY, X, EMPTY), Arrays.asList(EMPTY, EMPTY, EMPTY)), lines.rows());
    }

    @Test
    public void knowsItsColumns() {
        assertEquals(Arrays.asList(Arrays.asList(EMPTY, EMPTY, EMPTY), Arrays.asList(EMPTY, X, EMPTY), Arrays.asList(EMPTY, EMPTY, EMPTY)), lines.columns());
    }

    @Test
    public void knowsItsDiagonals() {
        assertEquals(Arrays.asList(Arrays.asList(EMPTY, X, EMPTY), Arrays.asList(EMPTY, X, EMPTY)), lines.diagonals());
    }

    @Test
    public void knowsAllPossibleCombinations() {
        assertEquals(Arrays.asList(Arrays.asList(EMPTY, EMPTY, EMPTY), Arrays.asList(EMPTY, X, EMPTY), Arrays.asList(EMPTY, EMPTY, EMPTY), Arrays.asList(EMPTY, EMPTY, EMPTY), Arrays.asList(EMPTY, X, EMPTY), Arrays.asList(EMPTY, EMPTY, EMPTY), Arrays.asList(EMPTY, X, EMPTY), Arrays.asList(EMPTY, X, EMPTY)), lines.possibleCombinations());
    }

}
