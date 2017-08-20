package ru.stolpner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application {

    private Board playerBoard;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Scene scene = new Scene(createScene());
        stage.setTitle("Battleship Commander");
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public Parent createScene() {
        BorderPane root = new BorderPane();

        playerBoard = new Board(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Cell cell = (Cell) event.getSource();
                playerBoard.placeShip(new Ship(cell.x, cell.y, true, 2));
            }
        });
//        playerBoard.autoPlaceShips();

        HBox vbox = new HBox(playerBoard);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
        root.setLeft(new Text("LEFT SIDEBAR - CONTROLS"));


        return root;
    }
}
