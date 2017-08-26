package ru.stolpner;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;

public class ControlPanel extends Parent {

    private VBox ships = new VBox();

    private int selectedLength = 0;
    private boolean isSelectedDirectionVertical = true;

    public ControlPanel() {
        for (int i = 0; i < 4; i++) {
            HBox ship = new HBox();
            ship.setPadding(new Insets(30, 0, 0, 0));
            ship.getChildren().add(new Text("Available: " + (i + 1)));
            for (int j = 0; j < 4 - i; j++) {
                ControlPanelCell c = new ControlPanelCell(4 - i, j, this);
                c.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        ControlPanelCell cell = (ControlPanelCell) event.getSource();
                        selectShipLength(cell.getShipLength());
                    }
                });
                ship.getChildren().add(c);
            }
            ships.getChildren().add(ship);
        }
        getChildren().add(ships);
        selectShipLength(4);
    }

    public int getSelectedLength() {
        return selectedLength;
    }

    public boolean isSelectedDirectionVertical() {
        return isSelectedDirectionVertical;
    }

    private void selectShipLength(int shipLength) {
        if (this.selectedLength == shipLength) return;
        if (this.selectedLength != 0 ) clearSelection();

        this.selectedLength = shipLength;
        List<Node> selectedShipNodes = ((HBox) ships.getChildren().get(4 - selectedLength)).getChildren();
        for (int i = 0; i < shipLength; i++) {
            ControlPanelCell c = (ControlPanelCell) selectedShipNodes.get(i + 1);      //cause Text is 0 element in row
            c.colorSelected();
        }
    }

    private void clearSelection() {
        List<Node> selectedShipNodes = ((HBox) ships.getChildren().get(4 - selectedLength)).getChildren();
        for (int i = 0; i < selectedLength; i++) {
            ControlPanelCell c = (ControlPanelCell) selectedShipNodes.get(i + 1);      //cause Text is 0 element in row
            c.resetColors();
        }
    }
}