import com.company.Board;
import org.junit.Test;

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
    public void boardCanBeMarkedWithX() {
        Board board = new Board();
        board.mark(4, 'X');
        assertArrayEquals(new char[]{'1', '2', '3', 'X', '5', '6', '7', '8', '9'}, board.showCells());
    }

    @Test
    public void boardMarkingsAlternate() {
        Board board = new Board();
        board.mark(1, 'X');
        board.mark(2, 'O');
        board.mark(3, 'X');
        assertArrayEquals(new char[]{'X', 'O', 'X', '4', '5', '6', '7', '8', '9'}, board.showCells());
    }
}
