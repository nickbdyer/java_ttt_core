package com.company;

public class DelayedComputer extends DumbComputer {

    private int delay;

    public DelayedComputer(Mark mark, int delay) {
        super(mark);
        this.delay = delay;
    }

    @Override
    public int choosePosition(UserInterface ui, Board board) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return super.choosePosition(ui, board);
    }
}
