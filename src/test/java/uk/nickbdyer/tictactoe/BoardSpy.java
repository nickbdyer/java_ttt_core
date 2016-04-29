package uk.nickbdyer.tictactoe;

public class BoardSpy extends Board {

    public boolean wasMarkCalled = false;
    private boolean hasAWinner;
    private boolean isADraw;

    @Override
    public void mark(int position, Mark mark) {
        wasMarkCalled = true;
    }

    @Override
    public boolean hasWinner() {
        return hasAWinner;
    }

    @Override
    public boolean isDraw() {
        return isADraw;
    }

    public void setADraw(boolean isADraw) {
        this.isADraw = isADraw;
    }

    public void setHasAWinner(boolean hasAWinner) {
        this.hasAWinner = hasAWinner;
    }
}
