package uk.nickbdyer.tictactoe;

import org.junit.Ignore;
import uk.nickbdyer.tictactoe.players.PlayerFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static uk.nickbdyer.tictactoe.Mark.EMPTY;
import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void knowsWhenTheGameIsOverDueToWin() {
        makeMultipleMoves(5, "1 2 4 5 7");
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        makeMultipleMoves(9, "1 2 4 5 8 7 3 6 9");
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        makeMultipleMoves(5, "1 2 4 5 7");
        assertEquals(X, board.getMarkAt(0));
        assertEquals(O, board.getMarkAt(1));
    }

    @Test
    public void willRejectOutOfBoundsEntry() {
        makeMultipleMoves(5, "23 0 3 1 4 2");
        assertEquals(Arrays.asList(X, X, X, O, O, EMPTY, EMPTY, EMPTY, EMPTY), board.getCells());
    }

    @Test
    public void willNotAllowAMarkedCellToBeMarked() {
        makeMultipleMoves(5, "1 1 4 2 5 3");
        assertEquals(Arrays.asList(X, X, X, O, O, EMPTY, EMPTY, EMPTY, EMPTY), board.getCells());
    }

    private void makeMultipleMoves(int numberOfMoves, String positions) {
        game = new Game(new PlayerFactory().create(GameType.HvsH));
        for (int i = 0; i < numberOfMoves; i++) {
            game.promptTurn(board);
        }
    }
}
