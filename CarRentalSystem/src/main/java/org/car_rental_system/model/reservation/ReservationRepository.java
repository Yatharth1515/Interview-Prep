package org.car_rental_system.model.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    private ConcurrentHashMap<Integer, Reservation> reservation = new ConcurrentHashMap<>();

    //Reservations per vehicle map
    private final  ConcurrentHashMap<Integer, List<Integer>> reservations = new ConcurrentHashMap<>();

    public Reservation findReservationById(int reservationId){

        return reservation.get(reservationId);
    }
    public Reservation saveReservation(int reservationId, Reservation reservation1){
      return reservation.putIfAbsent(reservationId, reservation1);
    }
    public List<Integer> reservationPerVehicle(int vehicleId){
        return reservations.getOrDefault(vehicleId, new ArrayList<>());
    }
    public void addOrUpdateReservation(int reservationId, int vehicleId){
        List<Integer> reservationListOfVehicle = reservationPerVehicle(vehicleId);
        reservationListOfVehicle.add(reservationId);
        reservations.put(vehicleId,reservationListOfVehicle);
    }
}
