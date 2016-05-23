package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.GameType;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.UserInterface;
import uk.nickbdyer.tictactoe.delayers.ThreadDelayer;
import uk.nickbdyer.tictactoe.exceptions.InvalidGameTypeException;

import java.util.Arrays;
import java.util.List;

import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;

public class PlayerFactory {

    private UserInterface ui;

    public PlayerFactory(UserInterface userInterface) {
        this.ui = userInterface;
    }

    public List<Player> create(GameType type) {
        if (type == GameType.HvsH) {
            return Arrays.asList(new Human(X, ui), new Human(O, ui));
        } else if (type == GameType.HvsAi) {
            return Arrays.asList(new Human(X, ui), slow(new DumbComputer(O)));
        } else if (type == GameType.AivsH) {
            return Arrays.asList(slow(new DumbComputer(X)), new Human(O, ui));
        } else if (type == GameType.AivsAi) {
            return Arrays.asList(slow(new DumbComputer(X)), slow(new DumbComputer(O)));
        } else if (type == GameType.HvsPAi) {
            return Arrays.asList(new Human(X, ui), slow(new PerfectComputer(O)));
        } else if (type == GameType.PAivsH) {
            return Arrays.asList(slow(new PerfectComputer(X)), new Human(O, ui));
        } else if (type == GameType.PAivsPAi) {
            return Arrays.asList(slow(new PerfectComputer(X)), slow(new PerfectComputer(O)));
        } else {
            throw new InvalidGameTypeException();
        }
    }

    private Player slow(Player computer) {
        return new DelayedComputer(computer, new ThreadDelayer(), 1000);
    }

}
