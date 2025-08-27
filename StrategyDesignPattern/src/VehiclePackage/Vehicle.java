package VehiclePackage;

import strategy.DriveStrategy;

public class Vehicle {
    private final DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy strategy){
        this.driveStrategy = strategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
