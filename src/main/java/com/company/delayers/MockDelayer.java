package com.company.delayers;

import com.company.Delayer;

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
