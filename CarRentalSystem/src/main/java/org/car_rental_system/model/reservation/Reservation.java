package org.car_rental_system.model.reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {
private int reservationId;
private int vehicleId;
private int userId;
private LocalDate  bookedFrom;
private LocalDate bookedTo;
private ReservationType reservationType;
private ReservationStatus reservationStatus;

    public Reservation(int reservationId, int vehicleId, int userId, LocalDate bookedFrom, LocalDate bookedTo, ReservationType reservationType, ReservationStatus reservationStatus) {
        this.reservationId = reservationId;
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.reservationType = reservationType;
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate  getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDate  bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public LocalDate  getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(LocalDate  bookedTo) {
        this.bookedTo = bookedTo;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return reservationId == that.reservationId && vehicleId == that.vehicleId && userId == that.userId && Objects.equals(bookedFrom, that.bookedFrom) && Objects.equals(bookedTo, that.bookedTo) && reservationType == that.reservationType && reservationStatus == that.reservationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, vehicleId, userId, bookedFrom, bookedTo, reservationType, reservationStatus);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", vehicleId=" + vehicleId +
                ", userId=" + userId +
                ", bookedFrom=" + bookedFrom +
                ", bookedTo=" + bookedTo +
                ", reservationType=" + reservationType +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
