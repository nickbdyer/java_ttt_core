package com.company;

import java.util.List;

public class Game {

    private List<Player> players;
    private Player currentPlayer;

    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayer = players.get(0);
    }

    public void play(UserInterface userInterface, Board board) {
        while (!isOver(board)) {
            userInterface.displayBoard(board);
            promptTurn(board, userInterface);
        }
        endGame(board, userInterface);
    }

    public boolean isOver(Board board) {
        return board.hasWinner() || board.isDraw();
    }

    private void promptTurn(Board board, UserInterface userInterface) {
        currentPlayer.markBoard(userInterface, board);
        swapPlayers();
    }

    private void endGame(Board board, UserInterface userInterface) {
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
