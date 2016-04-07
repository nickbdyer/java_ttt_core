import com.company.Board;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BoardTest {

    @Test
    public void boardIsInitializedWithAWidth() {
        Board board = new Board(3);
        assertEquals(3, board.getWidth());
        assertEquals(9, board.getSize());
    }
}
