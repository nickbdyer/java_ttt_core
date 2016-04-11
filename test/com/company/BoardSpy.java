import com.company.Board;

public class BoardSpy extends Board {

    public boolean wasMarkCalled = false;

    @Override
    public void mark(int position, char mark) {
        wasMarkCalled = true;
    }
}
