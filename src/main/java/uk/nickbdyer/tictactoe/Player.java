package uk.nickbdyer.tictactoe;

public interface Player {

    void markBoard(Board board, int position);

    int choosePosition(Board board);

    Mark getMark();

}
