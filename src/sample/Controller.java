package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    //Makes sure that it is the gridpane from my fxml file that i'm using
    @FXML
    GridPane gp_gameboard;
    Game game = new Game();
    /* Method that creates my game and uses my addRandomLivingCells method to make some of the cells alive.
    Then it takes the cells from my array and puts them into my gridpane from the fxml file.
    Green cells are alive while the blacks are dead
     */
    public void fillGrid(ActionEvent actionEvent) {

        game.update();

        for (int i = 0; i < Game.BOARDSIZE_X; i++) {
            for (int j = 0; j < Game.BOARDSIZE_Y; j++) {
                if(game.gameBoard[i][j].isAlive()){
                    gp_gameboard.add(new Rectangle(18,11, Color.valueOf("GREEN")), i,j);
                } else {
                    gp_gameboard.add(new Rectangle(18,11, Color.valueOf("BLACK")), i,j);
                }
            }
        }
    }

    //method that pauses the game if the button "stop" is pressed
    public void pauseGame(ActionEvent actionEvent) {
        game.addRandomLivingCells();

    }
}
