package com.company;

import com.company.Board;
import com.company.Display;

import java.io.PrintStream;
import java.util.Scanner;

public class DisplaySpy extends Display {

    public boolean wasShowBoardCalled = false;
    public boolean wasProcessMarkCalled = false;

    public DisplaySpy(Scanner input, PrintStream output) {
        super(input, output);
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
