package com.company;

import java.util.List;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = currentPlayer = player1;
        this.player2 = player2;
    }

    public Game(List<Player> players) {
        this.player1 = currentPlayer = players.get(0);
        this.player2 = players.get(1);
    }

    public void play(UserInterface userInterface, Board board) {
        while (!isOver(board)) {
            userInterface.showBoard(board);
            promptTurn(currentPlayer, board, userInterface);
        }
        endGame(board, userInterface);
    }

    public boolean isOver(Board board) {
        return board.hasWinner() || board.isDraw();
    }

    public void promptTurn(Player player, Board board, UserInterface userInterface) {
        player.markBoard(userInterface, board);
        swapPlayers();
    }

    private void endGame(Board board, UserInterface userInterface) {
        userInterface.showBoard(board);
        if (board.isDraw()) {
            userInterface.announceDraw();
        } else {
            userInterface.announceWinner(board);
        }
    }

    private void swapPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
