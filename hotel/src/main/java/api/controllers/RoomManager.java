package api.controllers;

import enums.RoomStatus;
import models.Room;

import java.util.List;

public interface RoomManager {

    public void addRoom(Room room);

    public void printRooms();

    public void changeRoomStatus(Room room, RoomStatus status);

    public void changeRoomPrice(Room room, double price);

    public String getRoomDetails(Room room);

    public List<Room> getSortedRoomsByPrice();

    public List<Room> getSortedRoomsByCapacity();

    public List<Room> getSortedRoomsByStars();

    public List<Room> getFreeRooms(List<Room> list);

    public int totalCountEmptyRooms();
}
