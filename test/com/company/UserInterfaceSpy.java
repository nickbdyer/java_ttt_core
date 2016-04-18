package com.company;

public class UserInterfaceSpy extends UserInterface {

    public boolean wasShowBoardCalled = false;
    public boolean wasProcessMarkCalled = false;
    public boolean wasAnnounceWinCalled = false;
    public boolean wasAnnounceDrawCalled = false;

    public UserInterfaceSpy() {
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

    @Override
    public void announceWinner(Board board) {
        wasAnnounceWinCalled = true;
    }

    @Override
    public void announceDraw() {
        wasAnnounceDrawCalled = true;
    }

    @Override
    public void displayComputerPlayingMessage() {}
}
