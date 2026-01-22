package models;

public class Door {
    DoorState doorState;
    Door(){
        doorState = DoorState.CLOSED;
    }

    public void openDoor() {
        doorState = DoorState.OPEN;
        System.out.println("door open");
    }

    public void closeDoor() {
        doorState = DoorState.CLOSED;
        System.out.println("door closed");
    }
}
