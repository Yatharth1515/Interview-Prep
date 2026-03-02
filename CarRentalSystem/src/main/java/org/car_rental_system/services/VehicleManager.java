package org.car_rental_system.services;

import org.car_rental_system.model.reservation.Reservation;
import org.car_rental_system.model.reservation.ReservationRepository;
import org.car_rental_system.model.vehicle.Vehicle;
import org.car_rental_system.model.vehicle.VehicleStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleManager {
    //map of vehicleId to vehicle
    private final  ConcurrentHashMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();
    private ReservationRepository reservationRepository;


    //lock per vehicle
    private final  ConcurrentHashMap<Integer, ReentrantLock> lockOnVehicle = new ConcurrentHashMap<>();

    private ReentrantLock lockForVehicle(int vId){
        lockOnVehicle.putIfAbsent(vId, new ReentrantLock());
        return lockOnVehicle.get(vId);
    }

    public void addVehicle(Vehicle vehicle){
        if(vehicle != null){
            this.vehicles.putIfAbsent(vehicle.getVehicleId(), vehicle);
        }

    }


    public boolean isVehicleAvailable(int vid, LocalDate bookedFrom , LocalDate bookedTo){
        Vehicle vehicleDetails = vehicles.get(vid);
        if(vehicleDetails == null) return false;
        if(VehicleStatus.BOOKED.equals(vehicleDetails.getVehicleStatus())) return false;

        DateInterval dateInterval = new DateInterval(bookedFrom, bookedTo);
        List<Integer> reservationIds = reservationRepository.reservationPerVehicle(vid);
        if( reservationIds.isEmpty()) return true;
        for(Integer it : reservationIds){
            Reservation reservation = reservationRepository.findReservationById(it);
            if(reservation == null) continue;
            LocalDate carBookedFrom = reservation.getBookedFrom();
            LocalDate carBookedTo = reservation.getBookedTo();
            DateInterval dateIntervalBooked = new DateInterval(carBookedFrom, carBookedTo);
            if (dateInterval.overLaps(dateIntervalBooked)) return false;
        }
        return true;
    }

    public boolean reserve(int vid, LocalDate bookedFrom , LocalDate bookedTo){
        ReentrantLock lock = lockForVehicle(vid);
        lock.lock();
        try {
            if(!isVehicleAvailable(vid,bookedFrom, bookedTo)) return false;

            Vehicle vehicle = vehicles.get(vid);
            vehicle.setVehicleStatus(VehicleStatus.BOOKED);
            return  true;

        }finally {
            lock.unlock();
        }

    }

    public void setReservationRepository(ReservationRepository reservationRepository1){
        this.reservationRepository = reservationRepository1;
    }
}
