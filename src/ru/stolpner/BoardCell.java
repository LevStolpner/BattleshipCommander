package ru.stolpner;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardCell extends Rectangle {

    private Ship ship;
    private Board board;

    public BoardCell(int x, int y, Board board) {
        super(x, y, 30, 30);
        this.board = board;
        this.resetColors();
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        setFill(Color.LIGHTSTEELBLUE);
        setStroke(Color.BLACK);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void resetColors() {
        setFill(Color.STEELBLUE);
        setStroke(Color.BLACK);
    }

    public void setHitColor() {
        setFill(Color.RED);
    }
}