package uk.nickbdyer.tictactoe;

public interface UserInterface {

    int getNumber();

    String getYorN();

    GameType makeGameChoice();

    void displayBoard(Board board);

    void displayMoveInstructions();

    void displayWinner(Board board);

    void displayDraw();

    void displayComputerThinking();

    void displayGameChoiceMenu();

    void displayInvalidInput();

    void displayInvalidSelection();

    void displayInvalidPosition();

    void displayReplayQuery();

    void displayResetNotice();
}
