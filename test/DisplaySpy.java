import com.company.Board;
import com.company.Display;

import java.util.Scanner;

public class DisplaySpy extends Display {

    public boolean wasShowBoardCalled = false;
    public boolean wasProcessMarkCalled = false;

    @Override
    public void showBoard(Board board) {
        wasShowBoardCalled = true;
    }

    @Override
    public void processMark(Scanner scanner, Board board, char mark) {
        wasProcessMarkCalled = true;
    }


}
