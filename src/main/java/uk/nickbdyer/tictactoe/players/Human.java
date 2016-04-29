package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Mark;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.UserInterface;

public class Human implements Player {

    private Mark mark;

    public Human(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(UserInterface ui, Board board) {
        ui.displayMoveInstructions();
        return ui.getNumber();
    }

    public Mark getMark() {
        return mark;
    }

}

