package main.java;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Board;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private Board playerBoard, enemyBoard;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Scene scene = new Scene(createScene());
        stage.setTitle("Battleship Commander");
        stage.setHeight(500);
        stage.setWidth(1000);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public Parent createScene() {
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 600);

        playerBoard = new Board(event -> {
//            Cell cell = (Cell) event.getSource();
//            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
//                if (--shipsToPlace == 0) {
//                    startGame();
//                }
//            }
        });
        enemyBoard = new Board(event -> {
//            Cell cell = (Cell) event.getSource();
//            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
//                if (--shipsToPlace == 0) {
//                    startGame();
//                }
//            }
        });
        playerBoard.autoPlaceShips();

        HBox vbox = new HBox(50, playerBoard, enemyBoard);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);

        return root;
    }
}
