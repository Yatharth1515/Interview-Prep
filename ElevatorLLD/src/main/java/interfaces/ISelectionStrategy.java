package interfaces;

import models.Direction;
import services.ElevatorController;

import java.util.List;

public interface ISelectionStrategy {
   ElevatorController selectElevator(List<ElevatorController> elevatorControllerList, Direction direction , int floor);
}
