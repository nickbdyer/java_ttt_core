package com.company;

import java.util.Collections;
import java.util.List;

public class DumbComputer implements Player {

    private Mark mark;

    public DumbComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(UserInterface ui, Board board) {
        ui.displayComputerThinking();
        return generateMove(board.availableMoves());
    }

     private int generateMove(List<Integer> availableMoves) {
        Collections.shuffle(availableMoves);
//         try {
//             Thread.sleep(1000);
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//         }
         return availableMoves.get(0);
    }

    public Mark getMark() {
        return mark;
    }
}
