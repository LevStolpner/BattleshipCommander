package main.java.model;

import java.util.List;

public class Battlefield {

    private Position battlefieldEnd;
    private List<Ship> ships;
    private List<Position> shots;

    public Battlefield(int battlefieldSize) {
        this.battlefieldEnd = new Position(battlefieldSize, battlefieldSize);
    }

    public void placeShip(Ship ship) {
        checkShipPlacement(ship);

    }

    //TODO check ship intersections
    private boolean checkShipPlacement(Ship ship) {
        Position pos = ship.getPosition();
        if (pos.getX() < 0 || pos.getY() < 0) {
            return false;
        }
        switch (ship.getDirection()) {
            case Vertical:
                return pos.getX() <= battlefieldEnd.getX() && pos.getY() + ship.getLength() - 1 <= battlefieldEnd.getY();
            default:
                return pos.getY() <= battlefieldEnd.getY() && pos.getX() + ship.getLength() - 1 <= battlefieldEnd.getX();
        }
    }
}
