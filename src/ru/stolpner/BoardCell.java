package ru.stolpner;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class BoardCell extends Rectangle {

    private Board board;
    private Ship ship;
    int x, y;

    BoardCell(int x, int y, Board board) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.board = board;
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}