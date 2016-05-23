package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Mark;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.UserInterface;
import uk.nickbdyer.tictactoe.exceptions.BoardUnplayableException;

import java.util.Collections;
import java.util.List;

public class DumbComputer implements Player {

    private Mark mark;

    public DumbComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(Board board, UserInterface ui) {
        if (board.isUnplayable()) throw new BoardUnplayableException();
        return generateMove(board.availableMoves());
    }

     private int generateMove(List<Integer> availableMoves) {
        Collections.shuffle(availableMoves);
         return availableMoves.get(0);
    }

    public Mark getMark() {
        return mark;
    }
}
