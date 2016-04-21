package com.company;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = currentPlayer = player1;
        this.player2 = player2;
    }

    public void run(UserInterface userInterface, Board board) {
        while (!isOver(board)) {
            userInterface.showBoard(board);
            promptTurn(currentPlayer, board, userInterface);
        }
        userInterface.showBoard(board);
        announceGameOver(board, userInterface);
    }

    public boolean isOver(Board board) {
        return (board.hasWinner() || board.isDraw());
    }

    private void announceGameOver(Board board, UserInterface userInterface) {
        if (board.isDraw()) {
            userInterface.announceDraw();
        } else if (board.hasWinner()) {
            userInterface.announceWinner(board);
        }
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private void swapPlayers() {
        if (currentPlayer == player1) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void promptTurn(Player player, Board board, UserInterface userInterface) {
        player.markBoard(userInterface, board);
        swapPlayers();
    }
}
