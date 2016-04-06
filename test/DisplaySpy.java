import com.company.Display;

public class DisplaySpy extends Display {

    public boolean wasShowBoardCalled = false;

    @Override
    public void showBoard() {
        wasShowBoardCalled = true;
    }


}
