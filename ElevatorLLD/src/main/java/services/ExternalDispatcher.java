package services;

import models.Direction;

public class ExternalDispatcher {
    private ElevatorScheduler elevatorScheduler;

    public ExternalDispatcher(ElevatorScheduler elevatorScheduler) {
        this.elevatorScheduler = elevatorScheduler;
    }

    public void submitRequest(Direction desiredDirection, int floor) {
        ElevatorController elevatorController = elevatorScheduler.selectElevator(desiredDirection, floor);
        elevatorController.submitRequest(floor);
    }
}
