package org.example.ParkingLotStrategy;

import org.example.ParkingLot.Models.ParkingSpot;
import org.example.ParkingLot.Models.Vehicle;
import org.example.ParkingLot.Models.VehicleType;
import org.example.ParkingLotManager.NearestSpotManager;
import org.example.ParkingLotManager.ParkingSpotManager;

import java.util.List;

public class SpotManagerFactory {
    ParkingSpotManager getSpotManager(VehicleType vehicleType, List<ParkingSpot> spots){
        return new NearestSpotManager(spots);
    }
}
