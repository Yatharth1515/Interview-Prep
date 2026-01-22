package models;

public class Display {
    int currFloor;
    Direction direction;


    public Display(int currFloor, Direction direction) {
        this.currFloor = currFloor;
        this.direction = direction;
    }

    public void showDisplay(int currFloor, Direction direction){
        System.out.println(" current floor " + currFloor + " moving in " + direction);
    }

    public int getCurrFloor() {
        return currFloor;
    }

    public void setCurrFloor(int currFloor) {
        this.currFloor = currFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
