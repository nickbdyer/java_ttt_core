package com.company;

public class GameEngine {
    public void start(UserInterface ui) {
        Game game = new Game(new PlayerFactory().create(ui.makeGameChoice()));
        Board board = new Board();
        while (!game.isOver(board)) {
            game.promptTurn(board, ui);
        }
        game.endGame(board, ui);
        ui.displayReplayQuery();
    }
}
