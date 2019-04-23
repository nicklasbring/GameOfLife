package sample;

public class Game {

    public static final int BOARDSIZE_X = 30;
    public static final int BOARDSIZE_Y = 30;

    Cell[][] gameBoard = new Cell[BOARDSIZE_X][BOARDSIZE_Y];

    public Game() {

        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {
                gameBoard[i][j] = new Cell();
            }
        }

    }

    public void addRandomLivingCells(){

        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {

                int temp = (int) (Math.random()*1.03);

                if (temp == 0){
                    gameBoard[i][j].setAlive(false);
                } else gameBoard[i][j].setAlive(true);
            }
        }

    }
}
