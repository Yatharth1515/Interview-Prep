package services;

import models.Direction;
import models.Elevator;
import models.InternalButton;

import javax.management.monitor.Monitor;
import java.awt.*;
import java.lang.management.MonitorInfo;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable{
    Elevator elevator;
    PriorityBlockingQueue<Integer> minPQ;
    PriorityBlockingQueue<Integer> maxPQ;

    public ElevatorController(Elevator elevator){
        this.elevator = elevator;
        this.minPQ = new PriorityBlockingQueue<>();
        this.maxPQ = new PriorityBlockingQueue<>(10, (a, b) -> b-a);
    }
    private final Object monitor = new Object();
    public void submitRequest(int destinationFloor){
        enqueueRequest(destinationFloor);
    }

    private void enqueueRequest(int destinationFloor) {
        System.out.println("destination floor");
        if(destinationFloor == elevator.getCurrFloor()){
            return;
        }
        if(destinationFloor >= elevator.getNextStop()){
            if(!minPQ.contains(destinationFloor)){
                minPQ.add(destinationFloor);
            }
        }
        else if (destinationFloor < elevator.getNextStop()){
            if(!maxPQ.contains(destinationFloor)){
                maxPQ.add(destinationFloor);
            }
        }
        synchronized (monitor){
            notify();
        }
    }

    @Override
    public void run() {
       controlElevator();
    }

    private void controlElevator() {
        while (true){
            synchronized (monitor){
                while(minPQ.isEmpty() && maxPQ.isEmpty()){
                    try {
                        System.out.println("Elevator is in " + Direction.IDLE  + " state");
                        elevator.setDirection(Direction.IDLE);
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            while (!minPQ.isEmpty()){
                int floor = minPQ.poll();
                System.out.println("destination floor " + floor);
                elevator.moveElevator(floor);
            }
            while (!maxPQ.isEmpty()){
                int floor = maxPQ.poll();
                System.out.println("destination floor " + floor);
                elevator.moveElevator(floor);
            }
        }
    }
}
