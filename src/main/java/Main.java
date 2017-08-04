package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static int BATTLEFIELD_SIZE = 10;

    public static void main(String[] args) {
        Battlefield field = new Battlefield(BATTLEFIELD_SIZE);
        ShipStock stock = createShipStock();

        //TODO start working on display (firstly show placed ships on one battlefield)
        imitatePlacingShips(stock).forEach(field::placeShip);
    }

    public static ShipStock createShipStock() {
        HashMap<Integer, Integer> ships = new HashMap<>();
        ships.put(4, 1);
        ships.put(3, 2);
        ships.put(2, 3);
        ships.put(1, 4);
        return new ShipStock(ships);
    }

    public static List<Ship> imitatePlacingShips(ShipStock stock) {
        List<Ship> result = new ArrayList<>();

        result.add(stock.takeShip(4));
        Ship lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(3, 9));
        lastShip.setDirection(Direction.Horizontal);

        result.add(stock.takeShip(3));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(7, 3));
        lastShip.setDirection(Direction.Horizontal);

        result.add(stock.takeShip(3));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(3, 7));
        lastShip.setDirection(Direction.Horizontal);

        result.add(stock.takeShip(2));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(4, 1));
        lastShip.setDirection(Direction.Vertical);

        result.add(stock.takeShip(2));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(8, 1));
        lastShip.setDirection(Direction.Horizontal);

        result.add(stock.takeShip(2));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(8, 7));
        lastShip.setDirection(Direction.Vertical);

        result.add(stock.takeShip(1));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(6, 0));
        lastShip.setDirection(Direction.Vertical);

        result.add(stock.takeShip(1));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(0, 4));
        lastShip.setDirection(Direction.Vertical);

        result.add(stock.takeShip(1));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(1, 6));
        lastShip.setDirection(Direction.Vertical);

        result.add(stock.takeShip(1));
        lastShip = result.get(result.size() - 1);
        lastShip.setPosition(new Position(9, 5));
        lastShip.setDirection(Direction.Vertical);

        return result;
    }
}
