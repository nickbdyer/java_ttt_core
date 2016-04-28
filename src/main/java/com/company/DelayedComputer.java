package com.company;

public class DelayedComputer implements Player {

    private int delay;
    private Player player;

    public DelayedComputer(Player player, int delay) {
        this.player = player;
        this.delay = delay;
    }

    @Override
    public int choosePosition(UserInterface ui, Board board) {
        try {
            Thread.sleep(delay);
            ui.displayComputerThinking();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return player.choosePosition(ui, board);
    }

    public Mark getMark() {
        return player.getMark();
    }
}
