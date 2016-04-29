package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;
import static org.junit.Assert.assertEquals;

public class DumbComputerTest {

    private DumbComputer hal9000;

    @Before
    public void setUp() throws Exception {
        hal9000 = new DumbComputer(O);
    }

    @Test
    public void getsMark() {
        assertEquals(O, hal9000.getMark());
    }

    @Test
    public void marksOnlyFreeCellOnBoard() {
        UserInterfaceSpy ui = new UserInterfaceSpy();
        Board board = new Board();
        leaveOneBoardCellEmpty(board);

        assertEquals(0, hal9000.choosePosition(ui, board));
    }

    private void leaveOneBoardCellEmpty(Board board) {
        for(int i=1;i<9;i++) {
            board.mark(i, X);
        }
    }
}