package sample;

public class Cell {

    private int isAlive;


    public Cell() {
    }

    public int isAlive() {
        return isAlive;
    }

    public void setAlive(int alive) {
        isAlive = alive;
    }

    int neighboursSum;
    int xPosition;
    int yPosition;

    public int getNeighboursSum() {
        return neighboursSum;
    }

    public void setNeighboursSum(int neighboursSum) {
        this.neighboursSum = neighboursSum;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean isAliveInNextStep() {


        if (isAlive == 0 && neighboursSum == 3) {
            return true;
        } else if (isAlive == 1 && (neighboursSum == 2 || neighboursSum == 3)) {
            return true;
        } else return false;

    }
}
