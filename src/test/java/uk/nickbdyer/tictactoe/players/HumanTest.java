package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.UserInterface;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static uk.nickbdyer.tictactoe.Mark.X;
import static org.junit.Assert.assertEquals;

public class HumanTest {

    private Human nick;

    @Before
    public void setUp() throws Exception {
        nick = new Human(X);
    }

    @Test
    public void canRetrieveItsMark() {
        assertEquals(X, nick.getMark());
    }

    @Test
    public void canMarkTheBoard() {
        Board board = new Board();
        UserInterface ui = new UserInterface(new Scanner("1"), new PrintStream(new ByteArrayOutputStream()));
        assertEquals(0, nick.choosePosition(ui, board));
    }

}
