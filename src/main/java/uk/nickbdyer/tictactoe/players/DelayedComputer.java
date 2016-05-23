package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.*;

public class DelayedComputer implements Player {

    private int delay;
    private Delayer delayer;
    private Player player;

    public DelayedComputer(Player player, Delayer delayer, int delay) {
        this.player = player;
        this.delayer = delayer;
        this.delay = delay;
    }

    @Override
    public int choosePosition(Board board, UserInterface ui) {
        delayer.sleep(delay);
        return player.choosePosition(board, ui);
    }

    public Mark getMark() {
        return player.getMark();
    }
}
