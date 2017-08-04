package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class ShipStock {

    private HashMap<Integer, List<Ship>> ships = new HashMap<>();

    public ShipStock(HashMap<Integer, Integer> shipsData) {
        shipsData.forEach((k, v) -> ships.put(k, new ArrayList<>(v).stream().map(s -> new Ship(k)).collect(Collectors.toList())));
    }

    public Ship takeShip(int length) {
        return ships.containsKey(length) ? ships.get(length).remove(ships.size() - 1) : null;
    }

    //TODO make ships returnable
}
