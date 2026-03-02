package org.car_rental_system.model.vehicle;

import java.util.Objects;

public class Vehicle {
    private int vehicleId;
    private String vehicleName;
    private VehicleType vehicleType;
    double dailyRentCost;
    private VehicleStatus vehicleStatus;

    public Vehicle(int vehicleId, String vehicleName, VehicleType vehicleType, double dailyRentCost, VehicleStatus vehicleStatus) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.dailyRentCost = dailyRentCost;
        this.vehicleStatus = vehicleStatus;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleType=" + vehicleType +
                ", dailyRentCost=" + dailyRentCost +
                ", vehicleStatus=" + vehicleStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getVehicleId() == vehicle.getVehicleId() && Double.compare(getDailyRentCost(), vehicle.getDailyRentCost()) == 0 && Objects.equals(getVehicleName(), vehicle.getVehicleName()) && getVehicleType() == vehicle.getVehicleType() && getVehicleStatus() == vehicle.getVehicleStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleId(), getVehicleName(), getVehicleType(), getDailyRentCost(), getVehicleStatus());
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getDailyRentCost() {
        return dailyRentCost;
    }

    public void setDailyRentCost(double dailyRentCost) {
        this.dailyRentCost = dailyRentCost;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
