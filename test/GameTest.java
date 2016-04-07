import com.company.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameTest {

    @Test
    public void setsUpGame() {
        Game game = new Game();
        DisplaySpy display = new DisplaySpy();
        BoardSpy board = new BoardSpy();
        game.run(display, board);
        assertTrue(display.wasShowBoardCalled);
    }
}