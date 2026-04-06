package services;

import interfaces.ISelectionStrategy;
import models.Direction;

import java.util.List;

public class ElevatorScheduler {

    private ISelectionStrategy strategy;
    private final List<ElevatorController> elevatorControllerList;
    public ElevatorScheduler(ISelectionStrategy strategy, List<ElevatorController> elevatorControllerList){
        this.strategy = strategy;
        this.elevatorControllerList = elevatorControllerList;
    }

   public ElevatorController selectElevator(Direction Desireddirection , int floor){
       return strategy.selectElevator(elevatorControllerList, Desireddirection,floor);
   }
}
