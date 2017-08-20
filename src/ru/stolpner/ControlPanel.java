package ru.stolpner;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

class ControlPanel extends Parent {

    private VBox shipModels = new VBox();
    private int selectedShipModel = 0;

    public ControlPanel() {

        for (int i = 0; i < 4; i++) {
            HBox shipModel = new HBox();
            shipModel.getChildren().add(new Text("Available: " + (i + 1)));
            for (int j = 0; j < 4 - i; j++) {
                ControlPanelCell c = new ControlPanelCell(i, j, this);
                c.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        ControlPanelCell cell = (ControlPanelCell) event.getSource();
                        selectShipModel(cell.getShipModel());
                    }
                });
                shipModel.getChildren().add(c);
            }
            shipModel.setPadding(new Insets(30, 0, 0, 0));
            shipModels.getChildren().add(shipModel);
        }
        getChildren().add(shipModels);
    }

    private void selectShipModel(int shipModel) {
        clearSelection();
        selectedShipModel = shipModel;

        List<Node> selectedShipNodes = ((HBox) shipModels.getChildren().get(shipModel)).getChildren();
        for (int i = 0; i < 4 - shipModel; i++) {
            ControlPanelCell c = (ControlPanelCell) selectedShipNodes.get(i + 1);      //cause Text is 0 element in row
            c.setFill(Color.BLUE);
        }
    }

    private void clearSelection() {
        List<Node> selectedShipNodes = ((HBox) shipModels.getChildren().get(selectedShipModel)).getChildren();
        for (int j = 0; j < 4 - selectedShipModel; j++) {
            ControlPanelCell c = (ControlPanelCell) selectedShipNodes.get(j + 1);      //cause Text is 0 element in row
            c.resetColors();
        }
    }
}
