package org.car_rental_system.model.Store;

import org.car_rental_system.model.vehicle.Vehicle;

import java.util.List;

public class Store {
    private String storeId;
    private String storeLocation;

    private List<Vehicle> vehicleList;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Store(String storeId, String storeLocation, List<Vehicle> vehicleList) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        this.vehicleList = vehicleList;
    }
}
