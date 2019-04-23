package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    GridPane gp_gameboard;

    public void fillGrid(ActionEvent actionEvent) {

        Game game = new Game();
        game.addRandomLivingCells();

        for (int i = 0; i < Game.BOARDSIZE_X; i++) {
            for (int j = 0; j < Game.BOARDSIZE_Y; j++) {
                if(game.gameBoard[i][j].isAlive()){
                    gp_gameboard.add(new Rectangle(18,11, Color.valueOf("RED")), i,j);
                } else {
                    gp_gameboard.add(new Rectangle(18,11, Color.valueOf("BLACK")), i,j);
                }
            }
        }
    }
}
