package ru.senla.datasource.room;

import ru.senla.entities.Room;

import java.util.List;

public interface IRoomsDatasource {
    public void addRoom(Room room);

    public void setRooms(List<Room> rooms);

    public List<Room> getRooms();
}
