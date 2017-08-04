package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static int BATTLEFIELD_SIZE = 10;

    public static void main(String[] args) {
        List<Battlefield> battlefields = new ArrayList<>(2);
        battlefields.add(new Battlefield(BATTLEFIELD_SIZE));
        battlefields.add(new Battlefield(BATTLEFIELD_SIZE));
    }

    public static ShipStock createShipStock() {
        HashMap<Integer, Integer> ships = new HashMap<>();
        ships.put(4, 1);
        ships.put(3, 2);
        ships.put(2, 3);
        ships.put(1, 4);
        return new ShipStock(ships);
    }
}
