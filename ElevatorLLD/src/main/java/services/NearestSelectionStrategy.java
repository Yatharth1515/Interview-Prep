package services;

import interfaces.ISelectionStrategy;
import models.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class NearestSelectionStrategy implements ISelectionStrategy {
    @Override
    public ElevatorController selectElevator(List<ElevatorController> elevatorControllerList, Direction direction, int floor) {
        if (elevatorControllerList == null || elevatorControllerList.isEmpty())
            return null;
        List<ElevatorController> elevatorsWithSameDirection = elevatorControllerList.stream().filter(elevator -> elevator.elevator.getDirection().equals(direction)).collect(Collectors.toList());
        ElevatorController selectedElevator = null;
        int min = Integer.MAX_VALUE;
        if (Direction.UP.equals(direction)) {

            for (ElevatorController elevatorController : elevatorsWithSameDirection) {
                if (floor >= elevatorController.elevator.getCurrFloor() && min > Math.abs(floor - elevatorController.elevator.getCurrFloor())) {
                    selectedElevator = elevatorController;
                    min = Math.abs(floor - elevatorController.elevator.getCurrFloor());
                }
            }

        } else {
            for (ElevatorController elevatorController : elevatorsWithSameDirection) {
                if (floor <= elevatorController.elevator.getCurrFloor() && min > Math.abs(floor - elevatorController.elevator.getCurrFloor())) {
                    selectedElevator = elevatorController;
                    min = Math.abs(floor - elevatorController.elevator.getCurrFloor());
                }
            }
        }
        // to check for idle elevators if they are near
        for (ElevatorController elevatorController : elevatorControllerList) {
            if (elevatorController.elevator.getDirection().equals(Direction.IDLE) && min > Math.abs(floor - elevatorController.elevator.getCurrFloor())) {
                selectedElevator = elevatorController;
                min = Math.abs(floor - elevatorController.elevator.getCurrFloor());
            }
        }

        return selectedElevator;
    }
}
