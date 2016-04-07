import com.company.Board;
import com.company.Display;

public class DisplaySpy extends Display {

    public boolean wasShowBoardCalled = false;

    @Override
    public void showBoard(Board board) {
        wasShowBoardCalled = true;
    }


}
