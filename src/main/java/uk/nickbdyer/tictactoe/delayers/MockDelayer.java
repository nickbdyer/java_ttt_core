package uk.nickbdyer.tictactoe.delayers;

import uk.nickbdyer.tictactoe.Delayer;

public class MockDelayer implements Delayer {

    public boolean hasSleepBeenCalled;

    public MockDelayer() {
        this.hasSleepBeenCalled = false;
    }

    @Override
    public void sleep(int delay) {
        hasSleepBeenCalled = true;
    }
}
