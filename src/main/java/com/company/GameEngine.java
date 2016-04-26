package com.company;

public class GameEngine {
    public void start(UserInterface ui) {
        ui.displayGameChoiceMenu();
        Game game = new Game(new PlayerFactory().create(ui.makeGameChoice()));
        Board board = new Board();
        game.play(ui, board);
        ui.displayReplayQuery();
    }
}
