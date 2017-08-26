package ru.stolpner;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class ControlPanel extends Parent {

    private VBox controls = new VBox();

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
            controls.getChildren().add(ship);
        }

        ToggleGroup group = new ToggleGroup();
        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                this.isSelectedDirectionVertical = (boolean) group.getSelectedToggle().getUserData();
            }
        });

        RadioButton rb1 = new RadioButton("Vertical");
        rb1.setToggleGroup(group);
        rb1.setUserData(true);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Horizontal");
        rb2.setToggleGroup(group);
        rb2.setUserData(false);

        controls.getChildren().add(rb1);
        controls.getChildren().add(rb2);
        getChildren().add(controls);

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
        List<Node> selectedShipNodes = ((HBox) controls.getChildren().get(4 - selectedLength)).getChildren();
        for (int i = 0; i < shipLength; i++) {
            ControlPanelCell c = (ControlPanelCell) selectedShipNodes.get(i + 1);      //cause Text is 0 element in row
            c.colorSelected();
        }
    }

    private void clearSelection() {
        List<Node> selectedShipNodes = ((HBox) controls.getChildren().get(4 - selectedLength)).getChildren();
        for (int i = 0; i < selectedLength; i++) {
            ControlPanelCell c = (ControlPanelCell) selectedShipNodes.get(i + 1);      //cause Text is 0 element in row
            c.resetColors();
        }
    }
}