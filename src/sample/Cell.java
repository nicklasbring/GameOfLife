package sample;

public class Cell {

    //Class variables
    private int livingNeighbours;
    private boolean alive;

    //Default constructor for default Cell
    public Cell() {
        livingNeighbours = 0;
        alive = false;
    }

    //Method that Updates Cells to be alive or dead
    public void update(){
            if (!alive && livingNeighbours == 3){
                alive = true;
            }
            else alive = alive && livingNeighbours == 2 || livingNeighbours == 3;
    }


    //Getters and setters
    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
