package models;

import services.ExternalDispatcher;

public class Floor {

    int currFloor;
    private ExternalButton externalButtonUP;
    private ExternalButton externalButtonDown;

    public Floor(int currFloor, ExternalDispatcher dispatcher) {
        this.currFloor = currFloor;
        this.externalButtonUP = new ExternalButton(dispatcher);
        this.externalButtonDown = new ExternalButton(dispatcher);
    }

    public void pressUpButton(){
        externalButtonUP.pressButton(Direction.UP, currFloor);
    }
    public void pressDownButton(){
        externalButtonDown.pressButton(Direction.DOWN, currFloor);
    }
}
