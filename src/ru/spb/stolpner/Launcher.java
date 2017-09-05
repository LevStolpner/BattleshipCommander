package ru.spb.stolpner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Launcher extends Application {

    private ControlPanel controlPanel;
    private Board playerBoard, computerBoard;

    //TODO: 1) separate placing part from shooting part (mark ships in controls when placed, better looking/more useful controls, visual display of game stage)
    //TODO: 2) when ships of length are all placed, jump to another model and make previous unselectable (if no more ships of type can be placed)
    //TODO: 3) refactoring
    //TODO: 4) work on hits (place on my board, shoot at enemy board)
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Battleship Commander");
        stage.setHeight(400);
        stage.setWidth(1000);
        stage.setScene(createScene());
        stage.setResizable(false);
        stage.show();
    }

    private Scene createScene() {
        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, null, null)));

        controlPanel = new ControlPanel();
        playerBoard = new Board(true, controlPanel);
        computerBoard = new Board(false, null);

        HBox controls = new HBox(controlPanel);
        controls.setPadding(new Insets(0, 0, 0, 50));
        controls.setAlignment(Pos.CENTER);
        root.setLeft(controls);

        HBox board = new HBox(50, playerBoard, computerBoard);
        board.setAlignment(Pos.CENTER);
        root.setCenter(board);

        return new Scene(root);
    }
}
