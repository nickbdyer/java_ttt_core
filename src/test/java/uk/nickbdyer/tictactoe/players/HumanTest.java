package uk.nickbdyer.tictactoe.players;

import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;

import static org.junit.Assert.assertEquals;
import static uk.nickbdyer.tictactoe.Mark.X;

public class HumanTest {

    @Test
    public void hasMark() {
        Human nick = new Human(X);
        assertEquals(X, nick.getMark());
    }

    @Test
    public void returnsMoveChoice() {
        Human nick = new Human(X);
        Board board = new Board();
        assertEquals(0, nick.choosePosition(board));
    }

}
