package ru.stolpner;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

class Board extends Parent {

    private HBox rows = new HBox();
    private final int size = 10;
    private List<Ship> ships;

    public Board(EventHandler<? super MouseEvent> handler) {
        for (int x = 0; x < size; x++) {
            VBox row = new VBox();
            for (int y = 0; y < size; y++) {
                BoardCell c = new BoardCell(x, y, this);
                c.setOnMouseClicked(handler);
                row.getChildren().add(c);
            }
            rows.getChildren().add(row);
        }
        getChildren().add(rows);

        this.ships = new ArrayList<>();
    }

    public void autoPlaceShips() {
        List<Ship> result = new ArrayList<>();
        result.add(new Ship(3, 9, false, 4));
        result.add(new Ship(7, 3, false, 3));
        result.add(new Ship(3, 7, false, 3));
        result.add(new Ship(4, 1, true, 2));
        result.add(new Ship(8, 1, false, 2));
        result.add(new Ship(8, 7, true, 2));
        result.add(new Ship(6, 0, true, 1));
        result.add(new Ship(0, 4, true, 1));
        result.add(new Ship(1, 6, true, 1));
        result.add(new Ship(9, 5, true, 1));

        result.forEach(this::placeShip);
    }

    public void placeShip(Ship ship) {
        if (checkShipCoordinates(ship) && isPlaceAvailable(ship)) {
            if (ship.isVertical()) {
                for (int i = ship.getY(); i < ship.getY() + ship.getLength(); i++) {
                    BoardCell cell = getCell(ship.getX(), i);
                    cell.setShip(ship);
                    cell.setFill(Color.WHITE);
                    cell.setStroke(Color.GREEN);
                }
            } else {
                for (int i = ship.getX(); i < ship.getX() + ship.getLength(); i++) {
                    BoardCell cell = getCell(i, ship.getY());
                    cell.setShip(ship);
                    cell.setFill(Color.WHITE);
                    cell.setStroke(Color.GREEN);
                }
            }

            ships.add(ship);
        }
    }

    private boolean checkShipCoordinates(Ship ship) {
        int x = ship.getX();
        int y = ship.getY();
        return !(x < 0 || y < 0) && (ship.isVertical() ? x < size && y + ship.getLength() <= size : y < size && x + ship.getLength() <= size);
    }

    private boolean isPlaceAvailable(Ship newShip) {
        for (Ship placedShip : ships) {
            if (checkShipOverlapping(newShip, placedShip)) return false;
        }
        return true;
    }

    private boolean checkShipOverlapping(Ship first, Ship second) {
        int[] firstBorders = first.getShipBorders();
        int[] secondBorders = second.getShipBorders();

        //checking overlapping of ships or areas around them
        return firstBorders[0] < secondBorders[2] && firstBorders[2] > secondBorders[0] &&
                firstBorders[1] < secondBorders[3] && firstBorders[3] > secondBorders[1];
    }

    private BoardCell getCell(int x, int y) {
        return (BoardCell)((VBox)rows.getChildren().get(x)).getChildren().get(y);
    }
}