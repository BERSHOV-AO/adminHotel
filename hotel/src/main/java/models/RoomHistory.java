package models;

import enums.RoomHistoryStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomHistory {

    private Room room;
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<Service> services = new ArrayList<>();
    private RoomHistoryStatus status;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public RoomHistoryStatus getStatus() {
        return status;
    }

    public void setStatus(RoomHistoryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomHistory{" +
                "room=" + room +
                ", guest=" + guest +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", services=" + services +
                ", status=" + status +
                '}';
    }
}
