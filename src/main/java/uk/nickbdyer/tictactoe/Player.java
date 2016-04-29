package uk.nickbdyer.tictactoe;

public interface Player {

    int choosePosition(UserInterface userInterface, Board board);

    Mark getMark();

}
