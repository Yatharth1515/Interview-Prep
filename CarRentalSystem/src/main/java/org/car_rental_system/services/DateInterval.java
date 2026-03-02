package org.car_rental_system.services;

import java.time.LocalDate;

public class DateInterval {
    private final LocalDate from;
    private final LocalDate to;

    public DateInterval(LocalDate from , LocalDate to){
        if(to.isBefore(from)){
            throw new IllegalArgumentException("End Date can't be before Start Date");
        }
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public boolean overLaps(DateInterval other){
        return this.from.isAfter(other.to) || this.to.isAfter(other.from);
    }
}
