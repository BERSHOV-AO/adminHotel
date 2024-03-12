package ru.senla.repository.room;

import ru.senla.datasource.room.IRoomsDatasource;
import ru.senla.datasource.room.RoomsDatasourceImpl;
import ru.senla.entities.Room;
import ru.senla.enums.RoomStatus;
import ru.senla.utils.csv_utils.RoomImportExport;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomsRepositoryImpl implements IRoomsRepository {
    IRoomsDatasource roomsDatasource = RoomsDatasourceImpl.getInstance();

    private static RoomsRepositoryImpl instance;

    private RoomsRepositoryImpl() {
    }

    public static RoomsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RoomsRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addRoom(Room room) {
        roomsDatasource.addRoom(room);
    }

    @Override
    public void setRooms(List<Room> rooms) {
        roomsDatasource.setRooms(rooms);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomsDatasource.getRooms();
    }

    @Override
    public void changeRoomStatus(Room room, RoomStatus status) {
        roomsDatasource.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setStatus(status);
                });
    }

    @Override
    public void changeRoomPrice(Room room, double price) {
        roomsDatasource.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    @Override
    public String getRoomDetails(Room room) {
        return roomsDatasource.getRooms().stream()
                .filter(r -> r.equals(room))
                .findFirst()
                .map(Room::toString)
                .orElse("Комната не найдена");
    }

    @Override
    public List<Room> getSortedRoomsByPrice() {
        return roomsDatasource.getRooms().stream()
                .sorted(Comparator.comparingDouble(Room::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortedRoomsByCapacity() {
        return roomsDatasource.getRooms().stream()
                .sorted(Comparator.comparingInt(Room::getCapacity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortedRoomsByStars() {
        return roomsDatasource.getRooms().stream()
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
        List<Room> emptyRooms = roomsDatasource.getRooms().stream()
                .filter(room -> room.getStatus() == RoomStatus.EMPTY)
                .collect(Collectors.toList());

        if (emptyRooms.isEmpty()) {
            return null;
        }
        return emptyRooms;
    }

    @Override
    public int totalCountEmptyRooms() {
        return getFreeRooms(roomsDatasource.getRooms()).size();
    }

    @Override
    public Room getRoomByNumber(Integer roomNumber) {
        return roomsDatasource.getRooms().stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Room getRoomById(int id) {
        return roomsDatasource.getRooms().stream()
                .filter(room -> (room.getId() == id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean checkRoomNumberExists(int roomNumber) {
        return roomsDatasource.getRooms().stream()
                .anyMatch(room -> room.getRoomNumber().equals(roomNumber));
    }

    @Override
    public boolean checkRoomIDExists(int roomId) {
        return roomsDatasource.getRooms().stream()
                .anyMatch(room -> room.getId() == roomId);
    }

    @Override
    public void exportRoomsToFileCSV() {
        RoomImportExport.exportRooms(roomsDatasource.getRooms());
    }

    @Override
    public void importCSVFilesToRooms() {
        roomsDatasource.setRooms(RoomImportExport.importRooms());
    }
}
