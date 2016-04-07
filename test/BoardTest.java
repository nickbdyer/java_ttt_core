import com.company.Board;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class BoardTest {

    @Test
    public void boardIsGenerated() {
        Board board = new Board();
        assertArrayEquals(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }

    @Test
    public void boardCanBeMarked() {
        Board board = new Board();
        board.mark(4);
        assertArrayEquals(new char[]{'1', '2', '3', 'X', '5', '6', '7', '8', '9'}, board.showCells());
    }
}
