package uk.nickbdyer.tictactoe;

import java.util.List;

public class Game {

    private List<Player> players;
    private Player currentPlayer;

    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayer = players.get(0);
    }

    public void promptTurn(Board board, UserInterface ui) {
        ui.displayBoard(board);
        board.mark(getValidPosition(ui, board), currentPlayer.getMark());
        swapPlayers();
    }

    private int getValidPosition(UserInterface ui, Board board) {
        int position = currentPlayer.choosePosition(ui, board);
        while (!board.availableMoves().contains(position)) {
            ui.displayInvalidPosition();
            position = currentPlayer.choosePosition(ui, board);
        }
        return position;
    }

    public void endGame(Board board, UserInterface ui) {
        ui.displayBoard(board);
        if (board.isDraw()) {
            ui.displayDraw();
        } else {
            ui.displayWinner(board);
        }
    }

    public boolean isOver(Board board) {
        return board.hasWinner() || board.isDraw();
    }

    private void swapPlayers() {
        if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
    }
}