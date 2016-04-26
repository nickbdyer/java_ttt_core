package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Player.Mark.O;
import static com.company.Player.Mark.X;

public class PlayerFactory {

    public List<Player> create(int option) {
        if (option == 1) {
            return Arrays.asList(new Human(X), new Human(O));
        } else if (option == 2) {
            return Arrays.asList(new Human(X), new DumbComputer(O));
        } else if (option == 3) {
            return Arrays.asList(new DumbComputer(X), new DumbComputer(O));
    }
        return new ArrayList<>();
    }

}
