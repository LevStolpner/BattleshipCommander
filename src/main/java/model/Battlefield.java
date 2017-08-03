package main.java.model;

import java.util.List;

public class Battlefield {

    private int battlefieldSize;
    private List<Ship> ships;
    private List<Position> shots;

    public Battlefield(int battlefieldSize) {
        this.battlefieldSize = battlefieldSize;
    }

    //TODO check ship intersections
    public void placeShip(Ship ship) {
        if (checkShipCoordinates(ship) && checkIntersectionsAndNearbyShips(ship)) {
            ships.add(ship);
        }
    }

    private boolean checkShipCoordinates(Ship ship) {
        Position pos = ship.getPosition();
        if (pos.getX() < 0 || pos.getY() < 0) return false;
        return ship.getDirection() == Direction.Vertical ?
                pos.getX() < battlefieldSize && pos.getY() + ship.getLength() <= battlefieldSize :
                pos.getY() < battlefieldSize && pos.getX() + ship.getLength() <= battlefieldSize;
    }

    //TODO check nearby ships (more than 1 cell between ships)
    private boolean checkIntersectionsAndNearbyShips(Ship newShip) {
        for (Ship placedShip : ships) {
            int placedX = placedShip.getPosition().getX();
            int placedY = placedShip.getPosition().getY();
            int newX = newShip.getPosition().getX();
            int newY = newShip.getPosition().getY();

            if (placedShip.getDirection() == newShip.getDirection()) {
                if (newShip.getDirection() == Direction.Vertical && placedX == newX ||
                        newShip.getDirection() == Direction.Horizontal && placedY == newY) {
                    return false;
                }
            } else {
                if ((placedShip.getDirection() == Direction.Vertical &&
                        placedY <= newY && placedY + placedShip.getLength() >= newY &&
                        placedX >= newX && placedX <= newX + newShip.getLength()) ||
                    (placedShip.getDirection() == Direction.Horizontal &&
                            placedX <= newX && placedX + placedShip.getLength() >= newX &&
                            placedY >= newY && placedY <= newY + newShip.getLength()))
                    return false;
            }
        }
        return true;
    }
}
