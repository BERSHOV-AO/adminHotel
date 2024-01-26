package models;

import java.time.LocalDate;

public class StayInfo {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Guest guest;

    public StayInfo(Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
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
