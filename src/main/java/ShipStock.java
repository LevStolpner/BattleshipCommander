package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class ShipStock {

    private HashMap<Integer, List<Ship>> ships;

    public ShipStock(HashMap<Integer, Integer> shipsData) {
        this.ships = new HashMap<>();
        shipsData.forEach((k, v) -> ships.put(k, Arrays.stream(new Integer[v]).map(s -> new Ship(k)).collect(Collectors.toList())));
    }

    public Ship takeShip(int length) {
        return ships.containsKey(length) ? ships.get(length).remove(ships.get(length).size() - 1) : null;
    }

    //TODO make ships returnable
}
