package services;

public class InternalDispatcher {

    private ElevatorController elevatorController;

    public InternalDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void pressButton(int destinationFloor) {
        System.out.println("Internal request for floor: " + destinationFloor);
        elevatorController.submitRequest(destinationFloor);
    }
}
