package uk.nickbdyer.tictactoe;

import static spark.Spark.*;

public class TicTacToeWeb {
    public static void main(String[] args) {
        get("/", (req, res) -> "TicTacToe");
//        new GameEngine().start(ui);
    }
}
