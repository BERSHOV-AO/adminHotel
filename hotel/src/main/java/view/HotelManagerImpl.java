package view;

import api.view.HotelManager;
import controllers.*;
import enums.RoomHistoryStatus;
import enums.RoomStatus;
import models.*;
import storages.RoomsStorageImpl;

import java.time.LocalDate;

public class HotelManagerImpl implements HotelManager {

    private static HotelManagerImpl instance;

    private HotelManagerImpl() {
    }

    public static HotelManagerImpl getInstance() {
        if (instance == null) {
            instance = new HotelManagerImpl();
        }
        return instance;
    }

    RoomManagerImpl roomManagerImpl = new RoomManagerImpl();
    ServiceManagerImpl serviceManagerImpl = new ServiceManagerImpl();
    GuestManagerImpl guestManagerImpl = new GuestManagerImpl();
    RoomHistoryManagerImpl roomHistoryManagerImpl = new RoomHistoryManagerImpl();
    StayInfoManagerImpl stayInfoManagerImpl = new StayInfoManagerImpl();

    // Service
    @Override
    public void showServicesSortByPrice() {
        serviceManagerImpl.sortByPrice().stream().forEach(System.out::println);
    }

    @Override
    public void showServicesSortBySection() {
        serviceManagerImpl.sortBySection().stream().forEach(System.out::println);
    }

    // Guest
    @Override
    public void addGuest(Guest guest) {
        guestManagerImpl.addOnGuest(guest);
    }

    @Override
    public void deleteGuest(Guest guest) {
        guestManagerImpl.deleteGuest(guest);
    }

    @Override
    public void printAllGuest() {
        guestManagerImpl.printGuest();
    }

    @Override
    public void sortGuestsByName() {
        guestManagerImpl.getSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }

    // Room
    @Override
    public void createRoom(Room room) {
        roomManagerImpl.addRoom(room);
    }

    @Override
    public void changeRoomStatus(Room room, RoomStatus roomStatus) {
        roomManagerImpl.changeRoomStatus(room, roomStatus);
    }

    @Override
    public void changeRoomPrice(Room room, double price) {
        roomManagerImpl.changeRoomPrice(room, price);
    }

    @Override
    public void printAllRooms() {
        roomManagerImpl.printRooms();
    }

    @Override
    public void printDetailsOfRoom(Room room) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room details: ");
        stringBuilder.append(roomManagerImpl.getRoomDetails(room));
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void sortRoomsByPrice() {
        roomManagerImpl.getSortedRoomsByPrice().stream().forEach(System.out::println);
    }

    @Override
    public void sortRoomsByCapacity() {
        roomManagerImpl.getSortedRoomsByCapacity().stream().forEach(System.out::println);
    }

    @Override
    public void sortRoomsByStars() {
        roomManagerImpl.getSortedRoomsByStars().stream().forEach(System.out::println);
    }

    @Override
    public void sortEmptyRoomsByPrice() {
        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByPrice()).stream().forEach(System.out::println);
    }

    @Override
    public void sortEmptyRoomsByCapacity() {
        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByCapacity()).stream().forEach(System.out::println);
    }

    @Override
    public void sortEmptyRoomsByStars() {
        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByStars()).stream().forEach(System.out::println);
    }

    @Override
    public void totalCountEmptyRooms() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("total Count Empty Rooms: ");
        stringBuilder.append(roomManagerImpl.totalCountEmptyRooms());
        System.out.println(stringBuilder.toString());
    }

    public Room getRoomByNumber(Integer roomNumber) {
        return roomManagerImpl.getRoomByNumber(roomNumber);
    }
    // stayInfoManagerImpl
    @Override
    public void showFreeRoomsByDate(LocalDate date) {
        stayInfoManagerImpl.getFreeRoomsByDate(date).stream()
                .forEach(item -> System.out.println("Комната с номером: " + item +
                        ", буде свободна - " + date.toString()));
    }

    @Override
    public void showPayAmountForRoom(Room room) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pay Amount For Room : ");
        stringBuilder.append(room.getRoomNumber() + " = ");
        stringBuilder.append(stayInfoManagerImpl.getPayAmountForRoom(room) + " руб.");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void printLastThreeGuests() {
        stayInfoManagerImpl.getLastThreeGuests().entrySet().stream()
                .forEach(entry -> {
                    Integer room = entry.getKey();
                    StayInfo stayInfo = entry.getValue();
                    LocalDate checkInDate = stayInfo.getCheckInDate();
                    LocalDate checkOutDate = stayInfo.getCheckOutDate();
                    Guest guest = stayInfo.getGuest();

                    System.out.println("Room: " + room);
                    System.out.println("Guest: " + guest.getLastName());
                    System.out.println("Check-in date: " + checkInDate);
                    System.out.println("Check-out date: " + checkOutDate);
                });
    }

    // Room History
    @Override
    public void printAllRoomHistories() {
        roomHistoryManagerImpl.printRoomHistories();
    }

    // Service
    @Override
    public void createService(Service service) {
        serviceManagerImpl.addService(service);
    }

    @Override
    public void changeServiceOnPrice(Service service, double price) {
        serviceManagerImpl.changeServicePrice(service, price);
    }

    @Override
    public void printAllService() {
        serviceManagerImpl.printService();
    }

    @Override
    public void showStayInfo() {
        stayInfoManagerImpl.printStayInfo();
    }

    @Override
    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {

        if (room.getStatus() == RoomStatus.EMPTY) {
            RoomHistory newRoomHistory = new RoomHistory();

            newRoomHistory.setGuest(guest);
            newRoomHistory.setRoom(room);
            newRoomHistory.setCheckInDate(checkInDate);
            newRoomHistory.setCheckOutDate(checkOutDate);
            newRoomHistory.setStatus(RoomHistoryStatus.CHECKIN);

            stayInfoManagerImpl.addStayInfo(room.getRoomNumber(), new StayInfo(guest, checkInDate, checkOutDate));
            roomHistoryManagerImpl.addHistory(newRoomHistory);
            roomManagerImpl.changeRoomStatus(room, RoomStatus.OCCUPIED);
        } else {
            System.out.println("Заселить в комнату " + room.getRoomNumber() + " не представляется возможным. "
                    + "Статус комнаты = " + room.getStatus());
        }
    }

    @Override
    public void checkOutGuestFromRoom(Guest guest, Room room) {
        if (room.getStatus() == RoomStatus.OCCUPIED) {
            stayInfoManagerImpl.deleteStayInfo(room.getRoomNumber());
            roomManagerImpl.changeRoomStatus(room, RoomStatus.EMPTY);
        } else {
            System.out.println("В комнате " + room.getRoomNumber() + " нет посетителей");
        }
    }
}





