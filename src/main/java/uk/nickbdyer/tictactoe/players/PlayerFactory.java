package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.GameType;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.Mark;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    public List<Player> create(GameType type) {
        if (type == GameType.HvsH) {
            return Arrays.asList(new Human(Mark.X), new Human(Mark.O));
        } else if (type == GameType.HvsAi) {
            return Arrays.asList(new Human(Mark.X), new DumbComputer(Mark.O));
        } else if (type == GameType.AivsH) {
            return Arrays.asList(new DumbComputer(Mark.X), new Human(Mark.O));
        } else if (type == GameType.AivsAi) {
            return Arrays.asList(new DumbComputer(Mark.X), new DumbComputer(Mark.O));
        } else if (type == GameType.HvsPAi) {
            return Arrays.asList(new Human(Mark.X), new PerfectComputer(Mark.O));
        } else if (type == GameType.PAivsH) {
            return Arrays.asList(new PerfectComputer(Mark.X), new Human(Mark.O));
        } else if (type == GameType.PAivsPAi) {
            return Arrays.asList(new PerfectComputer(Mark.X), new PerfectComputer(Mark.O));
        } else {
            throw new RuntimeException("That is not a game type");
        }
    }

}
