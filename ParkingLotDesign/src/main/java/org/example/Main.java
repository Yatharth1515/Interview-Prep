package org.example;

import org.example.ParkingLot.Models.*;
import org.example.ParkingLotManager.NearestSpotManager;
import org.example.ParkingLotManager.ParkingSpotManager;

import java.util.ArrayList;
import java.util.List;

import static org.example.ParkingLot.Models.VehicleType.FourWheeler;
import static org.example.ParkingLot.Models.VehicleType.TwoWheeler;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Welcome to Parking lot design");
        List<ParkingSpot> spots = new ArrayList<>();
        for (int i = 1; i <= 100 ; i++) {
            spots.add(new ParkingSpot(i,true,TwoWheeler,10) );
        }
        for (int i = 101; i <= 150 ; i++) {
            spots.add(new ParkingSpot(i,true,FourWheeler,40) );
        }

        // Create manager and gates
        ParkingSpotManager manager = new NearestSpotManager(spots);
        EntranceGate entranceGate = new EntranceGate(manager);
        ExitGate exitGate = new ExitGate(manager);


        Vehicle bike = new Vehicle(123, VehicleType.TwoWheeler);
        Ticket ticket = entranceGate.generateTicket(bike);
        if (ticket == null) return;

        Thread.sleep(3000);
        // Vehicle exits
        exitGate.processExit(ticket);
    }
}