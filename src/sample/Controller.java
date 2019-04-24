package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.awt.event.MouseEvent;

public class Controller {
    Game game = new Game();
    Timeline timeline;

    //Makes sure that it's the gridpane from my fxml file that i'm using
    @FXML
    GridPane bd_gameboard;


    //My button action method that paint the cells green if they're alive and grey if not
    public void fillGrid(ActionEvent actionEvent) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            for (int i = 0; i < Game.BOARDSIZE_X; i++) {
                for (int j = 0; j < Game.BOARDSIZE_Y; j++) {
                    if (game.gameBoard[i][j].isAlive()) {
                        bd_gameboard.add(new Rectangle(18, 11, Color.valueOf("GREEN")), i, j);
                    } else {
                        bd_gameboard.add(new Rectangle(18, 11, Color.valueOf("LIGHTGREY")), i, j);
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

    public void clickedOnBoard(javafx.scene.input.MouseEvent mouseEvent) {
        boolean onBoard = bd_gameboard.contains(new Point2D(mouseEvent.getX(), mouseEvent.getY()));

        double boardWidth = bd_gameboard.getWidth();
        double boardHight = bd_gameboard.getHeight();

        double cellWidth = boardWidth/Game.BOARDSIZE_X;
        double cellHieght = boardHight/Game.BOARDSIZE_Y;

        int xIndex = (int) (mouseEvent.getX()/cellWidth);
        int yIndex = (int) (mouseEvent.getY()/cellHieght);

        if (onBoard){
            game.changeCellStatusByMouse(xIndex, yIndex);
        }
    }
}