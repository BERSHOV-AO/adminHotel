package ru.senla.datasource.room;

import ru.senla.di_factory.Singleton;
import ru.senla.entities.Room;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RoomsDatasourceImpl implements IRoomsDatasource {

    private List<Room> rooms = new ArrayList<>();

    private static RoomsDatasourceImpl instance;

    public RoomsDatasourceImpl() {
    }

    public static RoomsDatasourceImpl getInstance() {
        if (instance == null) {
            instance = new RoomsDatasourceImpl();
        }
        return instance;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }
}
