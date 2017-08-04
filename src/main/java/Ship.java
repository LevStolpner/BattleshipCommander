package main.java;

public class Ship {

    private Position position;
    private Direction direction;
    private int length;
    private Position[] shipBox;

    public Ship(int length) {
        this.length = length;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return length;
    }

    public Position[] getShipBox() {
        return shipBox;
    }

    public void calculateShipBox() {
        if (this.position == null || this.direction == null) return;
        Position[] result = new Position[2];
        result[0] = new Position(this.position.getX() - 1, this.position.getY() - 1);
        if (this.direction == Direction.Vertical) {
            result[1] = new Position(this.position.getX() + 1, this.position.getY() + this.length + 1);
        } else {
            result[1] = new Position(this.position.getX() + this.length + 1, this.position.getY() + 1);
        }
        this.shipBox = result;
    }
}