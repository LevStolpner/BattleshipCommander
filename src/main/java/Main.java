package main.java;

import main.java.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int BATTLEFIELD_SIZE = 10;          //TODO complex figures for battlefields
                                                        //TODO HEXAGONAL positions

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(2);      //TODO games for more than 2?
        players.add(new Player());
        players.add(new Player());
        initializeBattlefields(players);
    }

    public static void initializeBattlefields(List<Player> players) {
        players.forEach(player -> player.initializeBattlefield(BATTLEFIELD_SIZE));
    }
}
