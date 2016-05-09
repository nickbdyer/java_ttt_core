package uk.nickbdyer.tictactoe.players;

import org.junit.Before;
import org.junit.Test;
import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.UserInterfaceSpy;
import uk.nickbdyer.tictactoe.exceptions.InvalidMoveException;

import static org.junit.Assert.assertEquals;
import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;

public class DumbComputerTest {

    private DumbComputer hal9000;

    @Before
    public void setUp() {
        hal9000 = new DumbComputer(O);
    }

    @Test
    public void hasMark() {
        assertEquals(O, hal9000.getMark());
    }

    @Test
    public void returnsMoveChoice() {
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        makeMultipleMarks(board, 8);
        assertEquals(8, hal9000.choosePosition(ui, board));
    }

    @Test(expected=InvalidMoveException.class)
    public void throwsExceptionIfBoardIsFull() {
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        makeMultipleMarks(board, 9);

        hal9000.choosePosition(ui, board);
    }

    private void makeMultipleMarks(Board board, int numMarkedCells) {
        for(int i=0;i<numMarkedCells;i++) {
            board.mark(i, X);
        }
    }
}