package com.company;

public interface Player {

    boolean equals(Object other);

    int hashCode();

    enum Mark{X,O,EMPTY};

    void markBoard(UserInterface userInterface, Board board);

    Mark getMark();

}
