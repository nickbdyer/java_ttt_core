import com.company.Board;
import com.company.Display;
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


    private final

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Display display;
    private BoardSpy board;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        display = new Display();
        board = new BoardSpy();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void showBoard() {
        display.showBoard(board);
        assertEquals(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n", outContent.toString());
    }

    @Test
    public void canProcessMark() {
        Scanner sc = new Scanner("1");
        display.processMark(sc, board, 'X');
        sc.close();
        assertTrue(board.wasMarkCalled);
    }

    @Test
    public void willRejectInvalidInputs() {
        Scanner sc = new Scanner("g 1");
        display.processMark(sc, board, 'X');
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
    }

    @Test
    public void willNotAllowaMarkedCelltobeMarked() {
        Board board = new Board();
        Scanner sc = new Scanner("1 1 2");
        display.processMark(sc, board, 'X');
        display.processMark(sc, board, 'O');
        sc.close();
        assertThat(outContent.toString(), containsString("That cell is already marked, try again"));
        assertArrayEquals(new char[]{'X', 'O', '3', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }

}
