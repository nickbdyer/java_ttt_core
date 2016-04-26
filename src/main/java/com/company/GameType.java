package com.company;

public enum GameType {
    HvsH(1),
    HvsAi(2),
    AivsH(3),
    AivsAi(4);

    public int value;

    GameType (int value) {
        this.value = value;
    }
}
