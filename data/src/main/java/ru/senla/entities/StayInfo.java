package ru.senla.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.senla.utils.RandomNumber;

import java.time.LocalDate;

public class StayInfo implements Entity {

    private int id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Guest guest;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public StayInfo(Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.id = RandomNumber.getRandomID();
    }

    @JsonCreator
    public StayInfo(@JsonProperty("id") int id,
                    @JsonProperty("guest") Guest guest,
                    @JsonProperty("checkInDate") LocalDate checkInDate,
                    @JsonProperty("checkOutDate") LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "StayInfo{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", guest=" + guest +
                '}';
    }
}
