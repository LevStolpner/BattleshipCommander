package main.java;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.Board;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private Board playerBoard;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
//        Scene scene = new Scene(createScene());
        Board board = new Board();
        board.autoPlaceShips();
        stage.setTitle("Battleship Commander");
        stage.setHeight(500);
        stage.setWidth(1000);
        stage.setResizable(false);
        stage.show();
    }

    public Parent createScene() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);

        return null;
    }
}
