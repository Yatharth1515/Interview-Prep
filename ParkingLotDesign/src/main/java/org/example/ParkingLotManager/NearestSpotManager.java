package org.example.ParkingLotManager;

import org.example.ParkingLot.Models.ParkingSpot;
import org.example.ParkingLot.Models.Vehicle;

import java.util.List;

public class NearestSpotManager implements ParkingSpotManager {
    List<ParkingSpot> spots;

    public NearestSpotManager(List<ParkingSpot> s) {
        this.spots = s;
    }

    @Override
    public ParkingSpot findSpot(Vehicle vehicle) {
        return spots.stream()
                .filter(ParkingSpot::isEmpty)
                .filter(s -> s.canFit(vehicle))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findSpot(vehicle);
        if (spot == null) {
            System.out.println("can not park, space is not available");
        } else
            spot.parkVehicle(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        spots.stream()
                .filter(s -> !s.isEmpty() && s.getVehicle().equals(vehicle))
                .findFirst()
                .ifPresent(ParkingSpot::removeVehicle);
    }

    @Override
    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }


}
