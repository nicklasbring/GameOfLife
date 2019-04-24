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

    //Makes sure that it's the gridpane from my fxml file that i'm using
    @FXML
    GridPane gp_gameboard;
    Game game = new Game();


    //My button action method that paint the cells green if they're alive and grey if not
    public void fillGrid(ActionEvent actionEvent) {
        game.update();

        for (int i = 0; i < Game.BOARDSIZE_X; i++) {
            for (int j = 0; j < Game.BOARDSIZE_Y; j++) {
                if(game.gameBoard[i][j].isAlive()){
                    gp_gameboard.add(new Rectangle(18,11, Color.valueOf("GREEN")), i,j);
                } else {
                    gp_gameboard.add(new Rectangle(18,11, Color.valueOf("LIGHTGREY")), i,j);
                }
            }
        }
    }

    //method that pauses the game if the button "stop" is pressed
    public void pauseGame(ActionEvent actionEvent) {
        game.addRandomLivingCells();
    }

    public void timer(){

    }

}
