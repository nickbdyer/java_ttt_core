package com.company;

public class Board {

    private int width;
    private int size;

    public Board(int width) {
        this.width = width;
        this.size = width * width;
    }

    public int getWidth() {
        return width;
    }

    public int getSize() {
        return size;
    }
}
