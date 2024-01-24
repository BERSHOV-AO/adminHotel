package controllers.room;

import enums.RoomStatus;
import models.Room;
import storages.room.RoomsStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomManagerImpl implements RoomManager {

    RoomsStorageImpl roomsStorage = RoomsStorageImpl.getInstance();

    private static RoomManagerImpl instance;

    private RoomManagerImpl() {
    }

    public static RoomManagerImpl getInstance() {
        if (instance == null) {
            instance = new RoomManagerImpl();
        }
        return instance;
    }

    @Override
    public void addRoom(Room room) {
        roomsStorage.addRoom(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomsStorage.getRooms();
    }

    @Override
    public void changeRoomStatus(Room room, RoomStatus status) {
        roomsStorage.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setStatus(status);
                });
    }

    @Override
    public void changeRoomPrice(Room room, double price) {
        roomsStorage.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    @Override
    public String getRoomDetails(Room room) {
        return roomsStorage.getRooms().stream()
                .filter(r -> r.equals(room))
                .findFirst()
                .map(Room::toString)
                .orElse("Комната не найдена");
    }

    @Override
    public List<Room> getSortedRoomsByPrice() {
        return roomsStorage.getRooms().stream()
                .sorted(Comparator.comparingDouble(Room::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortedRoomsByCapacity() {
        return roomsStorage.getRooms().stream()
                .sorted(Comparator.comparingInt(Room::getCapacity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortedRoomsByStars() {
        return roomsStorage.getRooms().stream()
                .sorted(Comparator.comparingInt(Room::getStars))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getFreeRooms(List<Room> list) {
        return list.stream()
                .filter(room -> room.getStatus() == RoomStatus.EMPTY)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getEmptyRooms() {
        List<Room> emptyRooms = roomsStorage.getRooms().stream()
                .filter(room -> room.getStatus() == RoomStatus.EMPTY)
                .collect(Collectors.toList());

        if (emptyRooms.isEmpty()) {
            return null;
        }
        return emptyRooms;
    }

    @Override
    public int totalCountEmptyRooms() {
        return getFreeRooms(roomsStorage.getRooms()).size();
    }

    @Override
    public Room getRoomByNumber(Integer roomNumber) {
        return roomsStorage.getRooms().stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElse(null);
    }
}

