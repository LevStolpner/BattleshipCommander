package ru.stolpner;

class Ship {

    private int x = -1;
    private int y = -1;
    private boolean vertical = true;
    private int length = 0;
    private int[] shipBorders = new int[4];

    public Ship(int x, int y, boolean vertical, int length) {
        this.x = x;
        this.y = y;
        this.vertical = vertical;
        this.length = length;
        setShipBorders();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public int getLength() {
        return length;
    }

    public int[] getShipBorders() {
        return shipBorders;
    }

    private void setShipBorders() {
        if (this.x < 0) return;          //check if ship has not been placed

        shipBorders = new int[4];
        shipBorders[0] = this.x - 1;
        shipBorders[1] = this.y - 1;
        shipBorders[2] = this.x + (this.vertical ? 1 : this.length);
        shipBorders[3] = this.y + (this.vertical ? this.length : 1);
    }
}