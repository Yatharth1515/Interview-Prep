package org.example.ParkingLot.Models;

public class ParkingSpot {
    int id;
    boolean isEmpty;
    Vehicle vehicle;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    private VehicleType vehicleType;
    int price;

    public ParkingSpot(int id, boolean isEmpty, VehicleType vehicle, int price) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.vehicleType = vehicle;
        this.price = price;
    }

    public ParkingSpot(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public boolean canFit(Vehicle v) {
        return this.vehicleType == v.getVehicleType();
    }
}
