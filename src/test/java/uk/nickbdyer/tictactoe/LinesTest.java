package uk.nickbdyer.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LinesTest {

    private Lines lines;

    @Before
    public void setUp() throws Exception {
        lines = new Lines(new ArrayList<Mark>(Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.X, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY, Mark.EMPTY)));
    }

    @Test
    public void knowsItsRows() {
        assertEquals(Arrays.asList(Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY)), lines.rows());
    }

    @Test
    public void knowsItsColumns() {
        assertEquals(Arrays.asList(Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY)), lines.columns());
    }

    @Test
    public void knowsItsDiagonals() {
        assertEquals(Arrays.asList(Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY)), lines.diagonals());
    }

    @Test
    public void knowsAllPossibleCombinations() {
        assertEquals(Arrays.asList(Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.EMPTY, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY), Arrays.asList(Mark.EMPTY, Mark.X, Mark.EMPTY)), lines.possibleCombinations());
    }

}
