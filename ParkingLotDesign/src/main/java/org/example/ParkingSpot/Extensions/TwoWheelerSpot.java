package org.example.ParkingSpot.Extensions;

import org.example.ParkingLot.Models.ParkingSpot;
import org.example.ParkingLot.Models.Vehicle;
import org.example.ParkingLot.Models.VehicleType;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(int id, int price) {
        super(id, price);
    }
    public boolean canFit(Vehicle v) {
        return v.getVehicleType() == VehicleType.TwoWheeler;
    }
}
