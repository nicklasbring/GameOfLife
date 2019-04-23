package sample;

public class Game {

    //Class variables
    public static final int BOARDSIZE_X = 30, BOARDSIZE_Y = 30;
    Cell[][] gameBoard = new Cell[BOARDSIZE_X][BOARDSIZE_Y];


    //Method for creating new game. Makes a cell for every rectangle to match my gridpane
    public Game() {
        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {
                gameBoard[i][j] = new Cell();
            }
        }
    }

    //Method that adds random number of living cells to my array
    public void addRandomLivingCells() {

        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {

                int temp = (int) (Math.random() * 1.5);

                if (temp == 0) {
                    gameBoard[i][j].setAlive(false);
                } else gameBoard[i][j].setAlive(true);
            }
        }
    }

    public void update(){
        neighboursCounter(gameBoard);

        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {
                gameBoard[i][j].update();
            }
        }
    }



    //Methods that evaluates how many neighbours the individual cell has
    public void neighboursCounter(Cell[][] gameBoard) {

        //variables used to determine neighbours
        int neighboursAlive;
        boolean north, northEast, east, southEast, south, southWest, west, northWest = false;

        //Runs through the whole board
        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {

                //Sets neighboursAlive to 0 after each time the loop runs
                neighboursAlive = 0;

                //Checks if the
                north = CellWithinBoard(i-1,j);
                northEast = CellWithinBoard(i-1,j+1);
                east = CellWithinBoard(i,j+1);
                southEast = CellWithinBoard(i+1,j+1);
                south = CellWithinBoard(i+1,j);
                southWest = CellWithinBoard(i+1,j-1);
                west = CellWithinBoard(i,j-1);
                northWest = CellWithinBoard(i-1,j-1);


                //If there is a living cell on the array location, neighbours will be incremented
                if(north){
                    if (gameBoard[i-1][j].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(northEast){
                    if (gameBoard[i-1][j+1].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(east){
                    if (gameBoard[i][j+1].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(southEast){
                    if (gameBoard[i+1][j+1].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(south){
                    if (gameBoard[i+1][j].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(southWest){
                    if (gameBoard[i+1][j-1].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(west){
                    if (gameBoard[i][j-1].isAlive()){
                        neighboursAlive++;
                    }
                }

                if(northWest){
                    if (gameBoard[i-1][j-1].isAlive()){
                        neighboursAlive++;
                    }
                }

                //Assign neighborCounter value to the Cells livingNeighbors variable
                gameBoard[i][j].setLivingNeighbours(neighboursAlive);
            }
        }
    }


    private boolean CellWithinBoard(int gridX, int gridY) {

        if((gridX < 0) || (gridY <0) ) {
            return false;    //false if row or col are negative
        }
        if((gridX >= BOARDSIZE_X) || (gridY >= BOARDSIZE_Y)) {
            return false;
        }
        return true;
    }
}
