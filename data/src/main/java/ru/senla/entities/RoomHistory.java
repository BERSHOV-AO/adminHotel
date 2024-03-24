package ru.senla.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.senla.enums.RoomHistoryStatus;

import java.time.LocalDate;


public class RoomHistory implements Entity {

    private int id;
    private Room room;
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private RoomHistoryStatus status;

    public RoomHistory() {

    }

    @JsonCreator
    public RoomHistory(@JsonProperty("id") int id,
                       @JsonProperty("room") Room room,
                       @JsonProperty("guest") Guest guest,
                       @JsonProperty("checkInDate") LocalDate checkInDate,
                       @JsonProperty("checkOutDate") LocalDate checkOutDate,
                       @JsonProperty("status") RoomHistoryStatus status) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

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

