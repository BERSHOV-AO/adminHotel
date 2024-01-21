package controllers.room;

import controllers.guest.GuestManagerImpl;
import enums.RoomStatus;
import models.Room;
import storages.room.RoomsStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomManagerImpl implements RoomManager {

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
        RoomsStorageImpl.getInstance().addRoom(room);
    }

    @Override
    public List<Room> getAllRooms() {
//        List<Room> tempRooms = RoomsStorageImpl.getInstance().getRooms();
//        for (Room room : tempRooms) {
//            System.out.println(room);
//        }
        return RoomsStorageImpl.getInstance().getRooms();
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
    public List<Room> getEmptyRooms() {
        List<Room> emptyRooms = RoomsStorageImpl.getInstance().getRooms().stream()
                .filter(room -> room.getStatus() == RoomStatus.EMPTY)
                .collect(Collectors.toList());

        if (emptyRooms.isEmpty()) {
            return null;
        }
        return emptyRooms;
    }

    @Override
    public int totalCountEmptyRooms() {
        return getFreeRooms(RoomsStorageImpl.getInstance().getRooms()).size();
    }

    @Override
    public Room getRoomByNumber(Integer roomNumber) {
        return RoomsStorageImpl.getInstance().getRooms().stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElse(null);
    }

//    @Override
//    public void printDetailsOfRoom(Room room) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Room details: ");
//        stringBuilder.append(getRoomDetails(room));
//        System.out.println(stringBuilder.toString());
//    }

    //-----------------------------------------------------------------------------------------

//    @Override
//    public void createRoom(Room room) {
//        roomManagerImpl.addRoom(room);
//    }

//    @Override
//    public void changeRoomStatus(Room room, RoomStatus roomStatus) {
//        roomManagerImpl.changeRoomStatus(room, roomStatus);
//    }

//    @Override
//    public void changeRoomPrice(Room room, double price) {
//        roomManagerImpl.changeRoomPrice(room, price);
//    }

//    @Override
//    public void printAllRooms() {
//        roomManagerImpl.printRooms();
//    }

//    @Override
//    public void printDetailsOfRoom(Room room) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Room details: ");
//        stringBuilder.append(roomManagerImpl.getRoomDetails(room));
//        System.out.println(stringBuilder.toString());
//    }

//    @Override
//    public void sortRoomsByPrice() {
//        roomManagerImpl.getSortedRoomsByPrice().stream().forEach(System.out::println);
//    }

//    @Override
//    public void showSortRoomsByCapacity() {
//        roomManagerImpl.getSortedRoomsByCapacity().stream().forEach(System.out::println);
//    }

//    @Override
//    public void showSortRoomsByStars() {
//        roomManagerImpl.getSortedRoomsByStars().stream().forEach(System.out::println);
//    }

//    @Override
//    public void showSortEmptyRoomsByPrice() {
//        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByPrice()).stream().forEach(System.out::println);
//    }

//    @Override
//    public void showSortEmptyRoomsByCapacity() {
//        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByCapacity()).stream().forEach(System.out::println);
//    }

//    @Override
//    public void showSortEmptyRoomsByStars() {
//        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByStars()).stream().forEach(System.out::println);
//    }

//    @Override
//    public void totalCountEmptyRooms() {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("total Count Empty Rooms: ");
//        stringBuilder.append(roomManagerImpl.totalCountEmptyRooms());
//        System.out.println(stringBuilder.toString());
//    }

//    @Override
//    public Room getRoomByNumber(Integer roomNumber) {
//        return roomManagerImpl.getRoomByNumber(roomNumber);
//    }

//    @Override
//    public void showEmptyRooms() {
//        if (roomManagerImpl.getEmptyRooms() == null) {
//            System.out.println("Нет свободных комнат");
//        } else {
//            roomManagerImpl.getEmptyRooms().stream().forEach(System.out::println);
//        }
//    }
}

