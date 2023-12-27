package api.storages;

import models.Room;

import java.util.List;

public interface RoomsStorage {

    public void addRoom(Room room);

    public void setRooms(List<Room> rooms);

    public List<Room> getRooms();
}
