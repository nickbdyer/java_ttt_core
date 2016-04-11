package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class DisplayTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BoardSpy board;

    @Before
    public void setUp() {
        board = new BoardSpy();
    }


    @Test
    public void showBoard() {
        Display display = new Display(new Scanner(""), new PrintStream(outContent));
        display.showBoard(board);
        assertEquals(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n", outContent.toString());
    }

    @Test
    public void canProcessMark() {
        Scanner sc = new Scanner("1");
        Display display = new Display(sc, new PrintStream(outContent));
        display.processMark(board, 'X');
        sc.close();
        assertTrue(board.wasMarkCalled);
    }

    @Test
    public void willRejectInvalidInputs() {
        Scanner sc = new Scanner("g 1");
        Display display = new Display(sc, new PrintStream(outContent));
        display.processMark(board, 'X');
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
    }

    @Test
    public void willNotAllowaMarkedCelltobeMarked() {
        Board board = new Board();
        Scanner sc = new Scanner("1 1 2");
        Display display = new Display(sc, new PrintStream(outContent));
        display.processMark(board, 'X');
        display.processMark(board, 'O');
        sc.close();
        assertThat(outContent.toString(), containsString("That cell is already marked, try again"));
        assertArrayEquals(new char[]{'X', 'O', '3', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }

}
