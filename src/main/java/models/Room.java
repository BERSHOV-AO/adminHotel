package models;

import enums.RoomStatus;

import java.util.Objects;

public class Room {
    private int roomNumber;
    private int stars;
    private double price;
    private int capacity;
    private RoomStatus status;

    public Room(int roomNumber, int stars, double price, int capacity, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.stars = stars;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", stars=" + stars +
                ", price=" + price +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && stars == room.stars && Double.compare(room.price, price) == 0 && capacity == room.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, stars, price, capacity);
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Room room = (Room) o;
//
//        if (roomNumber != room.roomNumber) return false;
//        if (stars != room.stars) return false;
//        if (Double.compare(room.price, price) != 0) return false;
//        if (capacity != room.capacity) return false;
//        return status == room.status;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = roomNumber;
//        result = 31 * result + stars;
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + capacity;
//        result = 31 * result + (status != null ? status.hashCode() : 0);
//        return result;
//    }
}