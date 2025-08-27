package org.example.ParkingLot.Models;

import org.example.ParkingLotManager.NearestSpotManager;
import org.example.ParkingLotManager.ParkingSpotManager;

public class ExitGate {
    private final ParkingSpotManager parkingSpotManager;

    public ExitGate(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }
    public void processExit(Ticket ticket) {
        long durationSeconds = (System.currentTimeMillis() - ticket.entryTime) / 1000;
        int totalCost = (int) durationSeconds * ticket.parkingSpot.getPrice();
        parkingSpotManager.removeVehicle(ticket.vehicle);
        System.out.println("Vehicle " + ticket.vehicle.getVehicleNo() + " exited.");
        System.out.println("Time: " + durationSeconds + " sec, Cost: " + totalCost);
    }

}
