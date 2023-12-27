package controllers;

import api.controllers.RoomManager;
import enums.RoomStatus;
import models.Room;
import storages.RoomsStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomManagerImpl implements RoomManager {

    @Override
    public void addRoom(Room room) {
        RoomsStorageImpl.getInstance().addRoom(room);
    }

    @Override
    public void printRooms() {
        List<Room> tempRooms = RoomsStorageImpl.getInstance().getRooms();
        for (Room room : tempRooms) {
            System.out.println(room);
        }
    }

    @Override
    public void changeRoomStatus(Room room, RoomStatus status) {
        RoomsStorageImpl.getInstance().getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setStatus(status);
                });
    }

    @Override
    public void changeRoomPrice(Room room, double price) {
        RoomsStorageImpl.getInstance().getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    @Override
    public String getRoomDetails(Room room) {
        return RoomsStorageImpl.getInstance().getRooms().stream()
                .filter(r -> r.equals(room))
                .findFirst()
                .map(Room::toString)
                .orElse("Комната не найдена");
    }

    @Override
    public List<Room> getSortedRoomsByPrice() {
        return RoomsStorageImpl.getInstance().getRooms().stream()
                .sorted(Comparator.comparingDouble(Room::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortedRoomsByCapacity() {
        return RoomsStorageImpl.getInstance().getRooms().stream()
                .sorted(Comparator.comparingInt(Room::getCapacity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortedRoomsByStars() {
        return RoomsStorageImpl.getInstance().getRooms().stream()
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
    public int totalCountEmptyRooms() {
        return getFreeRooms(RoomsStorageImpl.getInstance().getRooms()).size();
    }
}

