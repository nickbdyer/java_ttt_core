package com.company;

public interface Player {

    enum Mark{X,O,EMPTY};

    void markBoard(UserInterface userInterface, Board board);

    Mark getMark();

}
