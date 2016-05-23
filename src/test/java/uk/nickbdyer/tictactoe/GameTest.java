package uk.nickbdyer.tictactoe;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.players.PlayerFactory;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;

public class GameTest {

    private Game game;
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void knowsWhenTheGameIsOverDueToWin() {
        makeMultipleMoves(5, new int[]{0, 1, 3, 4, 6});
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        makeMultipleMoves(9, new int[]{0, 1, 2, 4, 5, 8, 7, 3, 6});
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        makeMultipleMoves(5, new int[]{0, 1, 3, 4, 6});
        assertEquals(X, board.getMarkAt(0));
        assertEquals(O, board.getMarkAt(1));
    }

    private void makeMultipleMoves(int numberOfMoves, int[] positions) {
        game = new Game(new PlayerFactory().create(GameType.HvsH));
        for (int i = 0; i < numberOfMoves; i++) {
            game.takeTurn(board, positions[i]);
        }
    }
}
