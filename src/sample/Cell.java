package sample;

public class Cell {

        private int livingNeighbours;
        private boolean alive;

    public Cell() {
        livingNeighbours = 0;
        alive = false;
    }

    public void update(){
            if (!alive && livingNeighbours == 3){
                alive = true;
            }
            else alive = alive && livingNeighbours == 2 || livingNeighbours == 3;
        }


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
