package main.java.model;

import java.util.*;

public class ShipStock {

    private HashMap<Integer, List<Ship>> ships = new HashMap<>();

    public ShipStock(HashMap<Integer, Integer> shipsData) {
        for(Map.Entry<Integer, Integer> entry : shipsData.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                if (ships.containsKey(entry.getKey())) {
                    ships.get(entry.getKey()).add(new Ship(entry.getKey()));
                } else {
                    ships.put(entry.getKey(), Collections.singletonList(new Ship(entry.getKey())));
                }
            }
        }
    }

    public Ship takeShip(int length) {
        return ships.containsKey(length) ? ships.get(length).remove(ships.size() - 1) : null;
    }

    //TODO make ships returnable
}
