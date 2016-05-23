package uk.nickbdyer.tictactoe;

import java.util.List;

public class Game {

    private List<Player> players;
    private Player currentPlayer;

    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayer = players.get(0);
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void promptTurn(Board board) {
        board.mark(getValidPosition(board), currentPlayer.getMark());
        swapPlayers();
    }

    private int getValidPosition(Board board) {
        int position = currentPlayer.choosePosition(board);
        while (!board.availableMoves().contains(position)) {
            position = currentPlayer.choosePosition(board);
        }
        return position;
    }

    public boolean isOver(Board board) {
        return board.isUnplayable();
    }

    public void swapPlayers() {
        if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
    }
}
