package uk.nickbdyer.tictactoe;

public interface Player {

    int choosePosition(Board board, UserInterface ui);

    Mark getMark();

}
