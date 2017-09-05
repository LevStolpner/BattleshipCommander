package ru.spb.stolpner;

public class Ship {

    private int x = -1;
    private int y = -1;
    private boolean vertical = true;
    private int length = 0;
    private int[] boundaries = new int[4];

    public Ship(int x, int y, boolean vertical, int length) {
        this.x = x;
        this.y = y;
        this.vertical = vertical;
        this.length = length;
        setBoundaries();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVertical() {
        return vertical;
    }

    public int getLength() {
        return length;
    }

    public int[] getBoundaries() {
        return boundaries;
    }

    public void setBoundaries() {
        if (this.x < 0) return;          //check if ship has not been placed

        boundaries = new int[4];
        boundaries[0] = this.x - 1;
        boundaries[1] = this.y - 1;
        boundaries[2] = this.x + (this.vertical ? 1 : this.length);
        boundaries[3] = this.y + (this.vertical ? this.length : 1);
    }
}