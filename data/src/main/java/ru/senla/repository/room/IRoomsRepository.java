package ru.senla.repository.room;

import ru.senla.entities.Room;
import ru.senla.enums.RoomStatus;

import java.util.List;

public interface IRoomsRepository {
    public void addRoom(Room room);

    public void setRooms(List<Room> rooms);

    public List<Room> getAllRooms();

    public void changeRoomStatus(Room room, RoomStatus status);

    public void changeRoomPrice(Room room, double price);

    public String getRoomDetails(Room room);

    public List<Room> getSortedRoomsByPrice();

    public List<Room> getSortedRoomsByCapacity();

    public List<Room> getSortedRoomsByStars();

    public List<Room> getFreeRooms(List<Room> list);

    public int totalCountEmptyRooms();

    public Room getRoomByNumber(Integer roomNumber);

    public List<Room> getEmptyRooms();

    public Room getRoomById(int id);

    public boolean checkRoomNumberExists(int roomNumber);

    public boolean checkRoomIDExists(int roomId);

    public void exportRoomsToFileCSV();

    public void importCSVFilesToRooms();
}
