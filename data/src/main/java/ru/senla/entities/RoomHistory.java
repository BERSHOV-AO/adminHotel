package ru.senla.entities;

import ru.senla.enums.RoomHistoryStatus;

import java.time.LocalDate;


public class RoomHistory implements Entity {


    private int id;
    private Room room;
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private RoomHistoryStatus status;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

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

    public RoomHistoryStatus getStatus() {
        return status;
    }

    public void setStatus(RoomHistoryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomHistory{" +
                "id=" + id +
                ", room=" + room +
                ", guest=" + guest +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", status=" + status +
                '}';
    }
}

