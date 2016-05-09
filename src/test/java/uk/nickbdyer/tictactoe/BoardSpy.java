package uk.nickbdyer.tictactoe;

import static uk.nickbdyer.tictactoe.Mark.EMPTY;

public class BoardSpy extends Board {

    public boolean wasMarkCalled = false;
    private boolean hasAWinner;
    private boolean isADraw;
    private boolean isEmpty;

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

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public Mark getWinningMark() {
        return EMPTY;
    }

    public void setHasAWinner(boolean hasAWinner) {
        this.hasAWinner = hasAWinner;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}
