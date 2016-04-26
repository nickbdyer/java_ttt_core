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
    public void displayBoard(Board board) {
        wasShowBoardCalled = true;
    }

    @Override
    public void makeMove(Board board, Player.Mark mark) {
        wasProcessMarkCalled = true;
    }

    @Override
    public void displayWinner(Board board) {
        wasAnnounceWinCalled = true;
    }

    @Override
    public void displayDraw() {
        wasAnnounceDrawCalled = true;
    }

    @Override
    public void displayComputerThinking() {}
}
