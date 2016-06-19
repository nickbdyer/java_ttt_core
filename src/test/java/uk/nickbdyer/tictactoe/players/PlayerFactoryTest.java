package uk.nickbdyer.tictactoe.players;

import org.junit.Test;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.exceptions.InvalidPlayerTypeException;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static uk.nickbdyer.tictactoe.Mark.X;
import static uk.nickbdyer.tictactoe.PlayerType.*;

public class PlayerFactoryTest {

    @Test
    public void canCreateHumanPlayer() {
        assertTrue(new PlayerFactory(new MockUI()).create(H, X) instanceof Human);
    }

    @Test
    public void canCreateComputerPlayer() {
        assertTrue(new PlayerFactory(new MockUI()).create(Ai, X) instanceof DumbComputer);
    }

    @Test
    public void canCreatePerfectComputerPlayer() {
        assertTrue(new PlayerFactory(new MockUI()).create(PAi, X) instanceof PerfectComputer);
    }

    @Test(expected=InvalidPlayerTypeException.class)
    public void throwsExceptionIfBoardIsFull() {
        new PlayerFactory(new MockUI()).create(TEST, X);
    }

}
