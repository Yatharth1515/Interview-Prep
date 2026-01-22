package models;

public class Elevator {
    String id;
    InternalButton button;
    Display display;
    int currFloor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getNextStop() {
        return nextStop;
    }

    public void setNextStop(int nextStop) {
        this.nextStop = nextStop;
    }

    Direction direction;
    Door door;
    int nextStop;

    public Elevator(String id) {
        this.id = id;
        this.button = new InternalButton();
        this.direction = Direction.IDLE;
        this.currFloor = 0;
        this.display = new Display(currFloor, Direction.IDLE);
        this.door = new Door();
    }

    public void moveElevator(int destinationFloor) {
        while (true) {
            this.nextStop = destinationFloor;
            if (currFloor == nextStop) {
                door.openDoor();
                display.showDisplay(nextStop, direction);
                return;
            }
            int startFloor = currFloor;
            door.openDoor();
             if (nextStop >= currFloor) {
                //moving up
                direction = Direction.UP;
                for (int i = startFloor + 1; i <= destinationFloor; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception ignored) {
                    }
                    setCurrFloor(i);
                    display.showDisplay(i, direction);
                }
            }
            else {
                direction = Direction.DOWN;
                for (int i = startFloor ; i >= nextStop  ; i--) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception ignored) {
                    }
                    setCurrFloor(i);
                    display.showDisplay(i, direction);
                }
            }
            door.closeDoor();
        }

    }
}
