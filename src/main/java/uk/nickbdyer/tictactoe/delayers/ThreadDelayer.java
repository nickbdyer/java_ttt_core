package uk.nickbdyer.tictactoe.delayers;

import uk.nickbdyer.tictactoe.Delayer;

public class ThreadDelayer implements Delayer {

    @Override
    public void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
