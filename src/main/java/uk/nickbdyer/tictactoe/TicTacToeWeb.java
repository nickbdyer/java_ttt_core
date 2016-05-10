package uk.nickbdyer.tictactoe;

import static spark.Spark.get;

public class TicTacToeWeb {

    public static void main(String[] args) {
        get("/", (req, res) -> "TicTacToe");
    }

}
