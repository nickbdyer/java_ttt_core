package com.company;

public class DisplaySpy extends Display {

    public boolean wasShowBoardCalled = false;
    public boolean wasProcessMarkCalled = false;

    public DisplaySpy() {
        super(null, null);
    }

    @Override
    public void showBoard(Board board) {
        wasShowBoardCalled = true;
    }

    @Override
    public void processMark(Board board, char mark) {
        wasProcessMarkCalled = true;
    }


}
