package models;

import utils.RandomNumber;

import java.time.LocalDate;

public class StayInfo {

    private int id = 0;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Guest guest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StayInfo(Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.id = RandomNumber.getRandomID();
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
