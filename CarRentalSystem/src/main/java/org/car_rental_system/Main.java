package org.car_rental_system;

import org.car_rental_system.model.Store.Store;
import org.car_rental_system.model.reservation.ReservationType;
import org.car_rental_system.model.user.User;
import org.car_rental_system.model.vehicle.Vehicle;
import org.car_rental_system.model.vehicle.VehicleStatus;
import org.car_rental_system.model.vehicle.VehicleType;
import org.car_rental_system.services.ReservationManager;
import org.car_rental_system.services.VehicleManager;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Vehicle v1 = new Vehicle(1, "G-Wagon", VehicleType.FOUR_WHEELER, 25000, VehicleStatus.AVAILABLE);
        Vehicle v2 = new Vehicle(2, "XuV", VehicleType.FOUR_WHEELER, 10000, VehicleStatus.AVAILABLE);
        Vehicle v3 = new Vehicle(3, "Hunter", VehicleType.TWO_WHEELER, 3000, VehicleStatus.AVAILABLE);
        VehicleManager vehicleManager = new VehicleManager();
        List<Vehicle> vehicleList = Arrays.asList(v1, v2, v3);
        vehicleList.forEach(vehicleManager::addVehicle);

        Store store = new Store("s1", "Pune", vehicleList);
        User user = new User(300, "Yatharth");

        ReservationManager reservationManager = new ReservationManager(vehicleManager);
        int reservationId = reservationManager.createReservation(1, LocalDate.now(), LocalDate.of(2026, 2, 24), ReservationType.DAILY, user.getUserId());
        confirmBooking(reservationId, 1);
        int reservationId2 = reservationManager.createReservation(1, LocalDate.of(2026, 2, 23), LocalDate.of(2026, 2, 24), ReservationType.DAILY, user.getUserId());
        confirmBooking(reservationId2, 1);
        int reservationId3 = reservationManager.createReservation(2, LocalDate.of(2026, 2, 23), LocalDate.of(2026, 2, 24), ReservationType.DAILY, user.getUserId());
        confirmBooking(reservationId3, 3);
    }

    public static void confirmBooking(int reservationId, int vid) {
        if (reservationId == -1)
            System.out.println("Booking not possible for this vehicle :- " + vid);
        else {
            System.out.println("Booking SuccessFul with ReservationId " + reservationId + " for this vehicle :- " + vid);
        }
    }
}