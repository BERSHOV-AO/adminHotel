package ru.senla.room;

import ru.senla.entities.Room;
import ru.senla.enums.RoomStatus;

import java.util.List;

public interface IRoomsService {

    public List<Room> getListRooms();

    public int getRoomNumberById(int roomId);

    public String addRoom(int roomId, Integer capacity, Double priceDay, Integer stars, RoomStatus status);

    public String changeRoomPrice(int roomId, Double newPrice);

    public String changeRoomStatus(int roomId, RoomStatus status);

    public String exportRoomsToFileCSV();

    public String importCSVFilesToRooms();

    public String printDetailsOneRoom(int roomId);

    public List<Room> printEmptyRooms();

    public List<Room> getListSortedRoomsByCapacity();

    public List<Room> getListSortedRoomsByPrice();

    public List<Room> getListSortedRoomsByStars();

    public List<Room> getListSortedEmptyRoomsByCapacity();

    public List<Room> getListSortedEmptyRoomsByPrice();

    public List<Room> getListSortedEmptyRoomsByStars();
}
