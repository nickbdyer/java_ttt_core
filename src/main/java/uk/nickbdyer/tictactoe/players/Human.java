package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.*;

public class Human implements Player {

    private Mark mark;

    public Human(Mark mark) {
        this.mark = mark;
    }

    @Override
    public int choosePosition(Board board, UserInterface ui) {
        return ui.getNumber();
    }

    public Mark getMark() {
        return mark;
    }

}

