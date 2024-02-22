package ru.senla.room;

import ru.senla.entities.Room;

import java.util.List;

public interface IRoomsService {

    public List<Room> getListRooms();

    public int getRoomNumberById(int roomId);
}
