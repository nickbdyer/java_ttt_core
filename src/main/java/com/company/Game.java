package com.company;

import java.util.List;

public class Game {

    private List<Player> players;
    private Player currentPlayer;

    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayer = players.get(0);
    }

    public boolean isOver(Board board) {
        return board.hasWinner() || board.isDraw();
    }

    public void promptTurn(Board board, UserInterface ui) {
        board.mark(getValidPosition(ui, board), currentPlayer.getMark());
        swapPlayers();
    }

    private int getValidPosition(UserInterface ui, Board board) {
        int position = currentPlayer.choosePosition(ui, board) - 1;
        while (!board.availableMoves().contains(position)) {
            ui.displayInvalidPosition();
            position = currentPlayer.choosePosition(ui, board) - 1;
        }
        return position;
    }

    public void endGame(Board board, UserInterface userInterface) {
        userInterface.displayBoard(board);
        if (board.isDraw()) {
            userInterface.displayDraw();
        } else {
            userInterface.displayWinner(board);
        }
    }

    private void swapPlayers() {
        if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
    }
}
