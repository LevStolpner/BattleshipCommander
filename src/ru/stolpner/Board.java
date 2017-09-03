package ru.stolpner;

import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board extends Parent {

    private final int size = 10;

    private HBox rows = new HBox();
    private List<Ship> ships;
    private HashMap<Integer, Integer> shipsOfLengthPlaced = new HashMap<>(4);
    private ControlPanel controls;

    public Board(boolean isPlayer, ControlPanel controls) {
        this.controls = controls;
        shipsOfLengthPlaced.put(1, 0);
        shipsOfLengthPlaced.put(2, 0);
        shipsOfLengthPlaced.put(3, 0);
        shipsOfLengthPlaced.put(4, 0);

        for (int x = 0; x < size; x++) {
            VBox row = new VBox();
            for (int y = 0; y < size; y++) {
                BoardCell c = new BoardCell(x, y, this);
                if (isPlayer) {
                    c.setOnMouseClicked(event -> {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            BoardCell cell = (BoardCell) event.getSource();
                            this.placeShip(new Ship((int) cell.getX(), (int) cell.getY(), this.controls.isSelectedDirectionVertical(), this.controls.getSelectedLength()));
                        }
                    });
                }
                row.getChildren().add(c);
            }
            rows.getChildren().add(row);
        }
        getChildren().add(rows);

        this.ships = new ArrayList<>();

        if (!isPlayer) {
            this.autoPlaceShips();
        }
    }

    private void autoPlaceShips() {
        int len = 4;
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        boolean vert = Math.random() < 0.5;
        while (len > 0) {
            for (int j = 0; j <= 4 - len; j++) {
                while (!placeShip(new Ship(x, y, vert, len))) {
                    x = (int) (Math.random() * 10);
                    y = (int) (Math.random() * 10);
                    vert = Math.random() < 0.5;
                }
            }
            len--;
        }
    }

    private boolean placeShip(Ship ship) {
        if (shipsOfLengthPlaced.get(ship.getLength()) <= 4 - ship.getLength() && checkShipCoordinates(ship) && isPlaceAvailable(ship)) {
            if (ship.isVertical()) {
                for (int i = ship.getY(); i < ship.getY() + ship.getLength(); i++) {
                    BoardCell cell = getCell(ship.getX(), i);
                    cell.setShip(ship);
                }
            } else {
                for (int i = ship.getX(); i < ship.getX() + ship.getLength(); i++) {
                    BoardCell cell = getCell(i, ship.getY());
                    cell.setShip(ship);
                }
            }

            shipsOfLengthPlaced.put(ship.getLength(), shipsOfLengthPlaced.get(ship.getLength()) + 1);
            ships.add(ship);
            return true;
        }

        return false;
    }

    private boolean checkShipCoordinates(Ship ship) {
        int x = ship.getX();
        int y = ship.getY();
        return !(x < 0 || y < 0) && (ship.isVertical() ? x < size && y + ship.getLength() <= size : y < size && x + ship.getLength() <= size);
    }

    private boolean isPlaceAvailable(Ship newShip) {
        if (ships == null) return true;
        for (Ship placedShip : ships) {
            if (checkShipOverlapping(newShip, placedShip)) return false;
        }
        return true;
    }

    private boolean checkShipOverlapping(Ship first, Ship second) {
        int[] firstBorders = first.getBoundaries();
        int[] secondBorders = second.getBoundaries();

        //checking overlapping of ships or areas around them
        return firstBorders[0] < secondBorders[2] && firstBorders[2] > secondBorders[0] &&
                firstBorders[1] < secondBorders[3] && firstBorders[3] > secondBorders[1];
    }

    private BoardCell getCell(int x, int y) {
        return (BoardCell) ((VBox) rows.getChildren().get(x)).getChildren().get(y);
    }
}
