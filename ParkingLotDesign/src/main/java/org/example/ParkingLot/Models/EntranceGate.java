package org.example.ParkingLot.Models;

import org.example.ParkingLotManager.NearestSpotManager;
import org.example.ParkingLotManager.ParkingSpotManager;

public class EntranceGate {
    private final ParkingSpotManager manager;
    public EntranceGate(ParkingSpotManager manager) {
        this.manager = manager;
    }
    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = manager.findSpot(vehicle);
        if (spot == null) {
            System.out.println("No spot available for vehicle " + vehicle.getVehicleNo());
            return null;
        }
        spot.parkVehicle(vehicle);
        return new Ticket(System.currentTimeMillis(), spot, vehicle);
    }

}
