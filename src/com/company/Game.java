package com.company;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void run(UserInterface userInterface, Board board, Player human, Player computer) {
        setUp(human, computer);
        while (!isOver(board)) {
            userInterface.showBoard(board);
            promptTurn(currentPlayer, board, userInterface);
        }
        userInterface.showBoard(board);
        announceGameOver(board, userInterface);
    }

    public void setUp(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1.setMark('X');
        this.player2.setMark('O');
        setCurrentPlayer(player1);
    }

    public boolean isOver(Board board) {
        return (board.hasAWinner() || board.isADraw());
    }

    private void announceGameOver(Board board, UserInterface userInterface) {
        if (board.isADraw()) {
            userInterface.announceDraw();
        } else if (board.hasAWinner()) {
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
