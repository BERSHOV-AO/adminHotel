package managers;

import enums.RoomStatus;
import models.Room;
import storages.RoomsStorage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomManager {
    public RoomsStorage roomsStorage = new RoomsStorage();

    public void addRoom(Room room) {
        roomsStorage.addRoom(room);
    }

    public void printRooms() {
        List<Room> tempRooms = roomsStorage.getRooms();
        for (Room room : tempRooms) {
            System.out.println(room);
        }
    }

    public void changeRoomStatus(Room room, RoomStatus status) {
        roomsStorage.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setStatus(status);
                });
    }

    public void changeRoomPrice(Room room, double price) {
        roomsStorage.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    public String getRoomDetails(Room room) {
        return roomsStorage.getRooms().stream()
                .filter(r -> r.equals(room))
                .findFirst()
                .map(Room::toString)
                .orElse("Комната не найдена");
    }

    public List<Room> getSortedRoomsByPrice() {
        return roomsStorage.getRooms().stream()
                .sorted(Comparator.comparingDouble(Room::getPrice))
                .collect(Collectors.toList());
    }

    public List<Room> getSortedRoomsByCapacity() {
        return roomsStorage.getRooms().stream()
                .sorted(Comparator.comparingInt(Room::getCapacity))
                .collect(Collectors.toList());
    }

    public List<Room> getSortedRoomsByStars() {
        return roomsStorage.getRooms().stream()
                .sorted(Comparator.comparingInt(Room::getStars))
                .collect(Collectors.toList());
    }

    public List<Room> getFreeRooms(List<Room> list) {
        return list.stream()
                .filter(room -> room.getStatus() == RoomStatus.EMPTY)
                .collect(Collectors.toList());
    }

    public int totalCountEmptyRooms() {
        return getFreeRooms(roomsStorage.getRooms()).size();
    }
}

