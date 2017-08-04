package main.java.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Battlefield {

    private int battlefieldSize;
    private List<Ship> ships;
    private List<Position> shots;

    public Battlefield(int battlefieldSize) {
        this.battlefieldSize = battlefieldSize;
    }

    public void placeShip(Ship ship) {
        if (isShipPlaceable(ship)) {
            ships.add(ship);
        }
    }

    private boolean isShipPlaceable(Ship ship) {
        return checkShipCoordinates(ship) && isPlaceAvailable(ship);
    }

    private boolean checkShipCoordinates(Ship ship) {
        Position pos = ship.getPosition();
        if (pos.getX() < 0 || pos.getY() < 0) return false;
        return ship.getDirection() == Direction.Vertical ?
                pos.getX() < battlefieldSize && pos.getY() + ship.getLength() <= battlefieldSize :
                pos.getY() < battlefieldSize && pos.getX() + ship.getLength() <= battlefieldSize;
    }

    private boolean isPlaceAvailable(Ship newShip) {
        newShip.setShipBox();

        for (Ship placedShip : ships) {
            Position[] placedShipBox = placedShip.getShipBox();
            if (checkBoxOverlapping(newShip.getShipBox(), placedShipBox)) return false;
        }
        return true;
    }

    private boolean checkBoxOverlapping(Position[] box1, Position[] box2) {
        return box1[0].getX() <= box2[1].getX() && box1[1].getX() >= box2[0].getX() &&
                box1[0].getY() <= box2[1].getY() && box1[1].getY() >= box2[0].getY();
    }
}
