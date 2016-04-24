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
        }
        return new ArrayList<>();
    }

}
