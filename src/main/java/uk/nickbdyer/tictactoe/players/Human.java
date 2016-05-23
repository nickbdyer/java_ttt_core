package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.*;

public class Human implements Player {

    private Mark mark;
    private UserInterface ui;

    public Human(Mark mark, UserInterface ui) {
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

