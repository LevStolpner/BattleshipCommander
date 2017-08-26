package ru.stolpner;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControlPanelCell extends Rectangle {

    private ControlPanel controlPanel;
    private int shipLength;
    private int cellNumber;

    public ControlPanelCell(int shipLength, int cellNumber, ControlPanel panel) {
        super(30, 30);
        this.shipLength = shipLength;
        this.cellNumber = cellNumber;
        this.controlPanel = panel;
        this.resetColors();
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public int getShipLength() {
        return shipLength;
    }

    public void setShipLength(int shipLength) {
        this.shipLength = shipLength;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public void resetColors() {
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }

    public void colorSelected() {
        setFill(Color.BLUE);
    }
}