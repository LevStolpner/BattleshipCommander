package ru.stolpner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Launcher extends Application {

    private ControlPanel controlPanel;
    private Board playerBoard;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Scene scene = new Scene(createScene());
        stage.setTitle("Battleship Commander");
        stage.setHeight(400);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private Parent createScene() {
        BorderPane root = new BorderPane();
        root.setLeft(createControls());
        root.setCenter(createBoard());
        return root;
    }

    private Node createControls() {
        controlPanel = new ControlPanel();

        HBox controls = new HBox(controlPanel);
        controls.setPadding(new Insets(0, 0, 0, 50));
        controls.setAlignment(Pos.CENTER);

        return controls;

    }

    private Node createBoard() {
        playerBoard = new Board(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                BoardCell cell = (BoardCell) event.getSource();
                playerBoard.placeShip(new Ship(cell.x, cell.y, true, 2));
            }
        });

        HBox board = new HBox(playerBoard);
        board.setAlignment(Pos.CENTER);

        return board;
    }
}
