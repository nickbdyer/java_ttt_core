import com.company.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DisplayTest {


    private final

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void showBoard() {
        Display display = new Display();
        BoardSpy board = new BoardSpy();
        display.showBoard(board);
        assertEquals(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n", outContent.toString());
    }

    @Test
    public void canProcessMark() {
        Display display = new Display();
        BoardSpy board = new BoardSpy();
        Scanner sc = new Scanner("1");
        display.processMark(sc, board, 'X');
        sc.close();
        assertTrue(board.wasMarkCalled);
    }
}
