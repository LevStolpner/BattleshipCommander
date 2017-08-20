package ru.stolpner;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class ControlPanelCell extends Rectangle {

    private ControlPanel controlPanel;
    int shipModel;
    int shipCell;

    ControlPanelCell(int shipModel, int shipCell, ControlPanel panel) {
        super(30, 30);
        this.shipModel = shipModel;
        this.shipCell = shipCell;
        this.controlPanel = panel;
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public int getShipModel() {
        return shipModel;
    }

    public void setShipModel(int shipModel) {
        this.shipModel = shipModel;
    }

    public int getShipCell() {
        return shipCell;
    }

    public void setShipCell(int shipCell) {
        this.shipCell = shipCell;
    }

    public void resetColors() {
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }
}