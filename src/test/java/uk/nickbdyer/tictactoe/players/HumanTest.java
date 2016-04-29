package uk.nickbdyer.tictactoe.players;

import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.UserInterface;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        UserInterface ui = new UserInterface(new Scanner("1"), new PrintStream(new ByteArrayOutputStream()));
        assertEquals(0, nick.choosePosition(ui, board));
    }

}
