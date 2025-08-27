package org.example.ParkingLotManager;

import org.example.ParkingLot.Models.ParkingSpot;
import org.example.ParkingLot.Models.Vehicle;

public interface ParkingSpotManager {
    ParkingSpot findSpot(Vehicle vehicle);
    void parkVehicle(Vehicle vehicle);
    void removeVehicle(Vehicle vehicle);
    void addParkingSpot(ParkingSpot parkingSpot);
}
