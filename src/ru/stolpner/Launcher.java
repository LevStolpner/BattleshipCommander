package ru.stolpner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Launcher extends Application {

    private ControlPanel controlPanel;
    private Board playerBoard;

    //TODO: 1) refactor all, polish controls and ship placing
    //TODO: 2) add enemy board, ship auto placing (visible)
    //TODO: 3) work on hits (place on my board, shoot at enemy board)
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Battleship Commander");
        stage.setHeight(400);
        stage.setWidth(800);
        stage.setScene(createScene());
        stage.setResizable(false);
        stage.show();
    }

    private Scene createScene() {
        BorderPane root = new BorderPane();

        controlPanel = new ControlPanel();
        playerBoard = new Board(true, controlPanel);

        HBox controls = new HBox(controlPanel);
        controls.setPadding(new Insets(0, 0, 0, 50));
        controls.setAlignment(Pos.CENTER);
        root.setLeft(controls);

        HBox board = new HBox(playerBoard);
        board.setAlignment(Pos.CENTER);
        root.setCenter(board);

        return new Scene(root);
    }
}
