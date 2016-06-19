package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Mark;
import uk.nickbdyer.tictactoe.PlayerType;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.UserInterface;
import uk.nickbdyer.tictactoe.delayers.ThreadDelayer;
import uk.nickbdyer.tictactoe.exceptions.InvalidPlayerTypeException;

import static uk.nickbdyer.tictactoe.PlayerType.*;

public class PlayerFactory {

    private UserInterface ui;

    public PlayerFactory(UserInterface userInterface) {
        this.ui = userInterface;
    }

    public Player create(PlayerType type, Mark mark) {
        if (type == H) {
            return new Human(mark, ui);
        } else if (type == Ai) {
            return new DumbComputer(mark);
        } else if (type == PAi) {
            return new PerfectComputer(mark);
        } else {
            throw new InvalidPlayerTypeException();
        }
    }

    private Player slow(Player computer) {
        return new DelayedComputer(computer, new ThreadDelayer(), 1000);
    }

}
