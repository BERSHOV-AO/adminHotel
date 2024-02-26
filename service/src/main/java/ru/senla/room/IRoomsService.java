package ru.senla.room;

import ru.senla.entities.Room;
import ru.senla.enums.RoomStatus;

import java.util.List;

public interface IRoomsService {

    public List<Room> getListRooms();

    public int getRoomNumberById(int roomId);

    public String addRoom(int roomId, Integer capacity, Double priceDay, Integer stars, RoomStatus status);

    public String changeRoomPrice(int roomId, Double newPrice);
}
