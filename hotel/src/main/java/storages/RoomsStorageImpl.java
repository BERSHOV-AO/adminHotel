package storages;

import api.storages.RoomsStorage;
import models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomsStorageImpl implements RoomsStorage {
    private List<Room> rooms = new ArrayList<>();

    private static RoomsStorageImpl instance;

    private RoomsStorageImpl() {
    }

    public static RoomsStorageImpl getInstance() {
        if (instance == null) {
            instance = new RoomsStorageImpl();
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

