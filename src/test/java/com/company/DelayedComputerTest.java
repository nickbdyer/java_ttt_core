package com.company;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static com.company.Mark.X;
import static org.junit.Assert.assertTrue;

public class DelayedComputerTest {

    @Test
    public void canGenerateMove() {
        UserInterface ui = new UserInterface(new Scanner(""), new PrintStream(new ByteArrayOutputStream()));
        Board board = new Board();
        DelayedComputer delayedComputer = new DelayedComputer(X,0);
        delayedComputer.choosePosition(ui, board);
        assertTrue(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8).contains(delayedComputer.choosePosition(ui, board)));
    }
}
