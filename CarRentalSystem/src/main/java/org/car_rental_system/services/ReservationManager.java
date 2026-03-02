package org.car_rental_system.services;

import org.car_rental_system.model.reservation.Reservation;
import org.car_rental_system.model.reservation.ReservationRepository;
import org.car_rental_system.model.reservation.ReservationStatus;
import org.car_rental_system.model.reservation.ReservationType;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    private final VehicleManager vehicleManager;
    private final ReservationRepository reservationRepository;

    private final AtomicInteger reservationIdGenerator = new AtomicInteger(0);

    public ReservationManager(VehicleManager vehicleManager) {
        this.vehicleManager = vehicleManager;
        this.reservationRepository = new ReservationRepository();
        vehicleManager.setReservationRepository(reservationRepository);
    }

    public int createReservation(int vehicleId, LocalDate bookFrom, LocalDate bookTo, ReservationType reservationType, int userId) {
        int reservationId = reservationIdGenerator.getAndIncrement();
        boolean reserve = vehicleManager.reserve(vehicleId, bookFrom, bookTo);
        if (!reserve) return -1;
        Reservation newReservation = new Reservation(reservationId, vehicleId, userId, bookFrom, bookTo, reservationType, ReservationStatus.SCHEDULED);
        reservationRepository.addOrUpdateReservation(reservationId,vehicleId);
         reservationRepository.saveReservation(reservationId, newReservation);
         return reservationId;

    }


}
