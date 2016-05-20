package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Mark;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.CLI;

public class Human implements Player {

    private Mark mark;
    private CLI ui;

    public Human(Mark mark, CLI ui) {
        this.mark = mark;
        this.ui = ui;
    }

    @Override
    public int choosePosition(Board board) {
        ui.displayMoveInstructions();
        return ui.getNumber();
    }

    public Mark getMark() {
        return mark;
    }

}

