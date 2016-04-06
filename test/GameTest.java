import com.company.Display;
import com.company.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GameTest {

    @Test
    public void setsUpGame() {
        Game game = new Game();
        DisplaySpy display = new DisplaySpy();
        game.run(display);
        assertTrue(display.wasShowBoardCalled);
    }
}