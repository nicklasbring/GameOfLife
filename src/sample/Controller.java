package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {
    Game game = new Game();
    Timeline timeline;

    //Makes sure that it's the gridpane from my fxml file that i'm using
    @FXML
    GridPane gp_gameboard;


    //My button action method that paint the cells green if they're alive and grey if not
    public void fillGrid(ActionEvent actionEvent) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            for (int i = 0; i < Game.BOARDSIZE_X; i++) {
                for (int j = 0; j < Game.BOARDSIZE_Y; j++) {
                    if (game.gameBoard[i][j].isAlive()) {
                        gp_gameboard.add(new Rectangle(18, 11, Color.valueOf("GREEN")), i, j);
                    } else {
                        gp_gameboard.add(new Rectangle(18, 11, Color.valueOf("LIGHTGREY")), i, j);
                    }
                }
            }
            game.update();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


        //method that pauses the game if the button "stop" is pressed
    public void pauseGame(ActionEvent actionEvent){
        timeline.stop();
    }

    public void randomCells(ActionEvent actionEvent) {
        game.addRandomLivingCells();
    }
}