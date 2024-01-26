package managers;

import enums.RoomHistoryStatus;
import enums.RoomStatus;
import models.*;

import java.time.LocalDate;

public class HotelManager {
    RoomManager roomManager = new RoomManager();
    ServiceManager serviceManager = new ServiceManager();
    GuestManager guestManager = new GuestManager();
    RoomHistoryManager roomHistoryManager = new RoomHistoryManager();
    StayInfoManager stayInfoManager = new StayInfoManager();

    // Service
    public void showServicesSortByPrice() {
        serviceManager.sortByPrice().stream().forEach(System.out::println);
    }

    public void showServicesSortBySection() {
        serviceManager.sortBySection().stream().forEach(System.out::println);
    }

    // Guest
    public void addGuest(Guest guest) {
        guestManager.addOnGuest(guest);
    }

    public void deleteGuest(Guest guest) {
        guestManager.deleteGuest(guest);
    }

    public void printAllGuest() {
        guestManager.printGuest();
    }

    public void sortGuestsByName() {
        guestManager.getSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }

    // Room
    public void createRoom(Room room) {
        roomManager.addRoom(room);
    }

    public void changeRoomStatus(Room room, RoomStatus roomStatus) {
        roomManager.changeRoomStatus(room, roomStatus);
    }

    public void changeRoomPrice(Room room, double price) {
        roomManager.changeRoomPrice(room, price);
    }

    public void printAllRooms() {
        roomManager.printRooms();
    }

    public void printDetailsOfRoom(Room room) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room details: ");
        stringBuilder.append(roomManager.getRoomDetails(room));
        System.out.println(stringBuilder.toString());
    }

    public void sortRoomsByPrice() {
        roomManager.getSortedRoomsByPrice().stream().forEach(System.out::println);
    }

    public void sortRoomsByCapacity() {
        roomManager.getSortedRoomsByCapacity().stream().forEach(System.out::println);
    }

    public void sortRoomsByStars() {
        roomManager.getSortedRoomsByStars().stream().forEach(System.out::println);
    }

    public void sortEmptyRoomsByPrice() {
        roomManager.getFreeRooms(roomManager.getSortedRoomsByPrice()).stream().forEach(System.out::println);
    }

    public void sortEmptyRoomsByCapacity() {
        roomManager.getFreeRooms(roomManager.getSortedRoomsByCapacity()).stream().forEach(System.out::println);
    }

    public void sortEmptyRoomsByStars() {
        roomManager.getFreeRooms(roomManager.getSortedRoomsByStars()).stream().forEach(System.out::println);
    }

    public void totalCountEmptyRooms() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("total Count Empty Rooms: ");
        stringBuilder.append(roomManager.totalCountEmptyRooms());
        System.out.println(stringBuilder.toString());
    }

    public void showFreeRoomsByDate(LocalDate date) {
        stayInfoManager.getFreeRoomsByDate(date).stream()
                .forEach(item -> System.out.println("Комната с номером: " + item +
                        ", буде свободна - " + date.toString()));
    }

    public void showPayAmountForRoom(Room room) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pay Amount For Room : ");
        stringBuilder.append(room.getRoomNumber() + " = ");
        stringBuilder.append(stayInfoManager.getPayAmountForRoom(room) + " руб.");
        System.out.println(stringBuilder.toString());
    }

    public void printLastThreeGuests() {
        stayInfoManager.getLastThreeGuests().entrySet().stream()
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
    public void printAllRoomHistories() {
        roomHistoryManager.printRoomHistories();
    }

    // Service
    public void createService(Service service) {
        serviceManager.addService(service);
    }

    public void changeServiceOnPrice(Service service, double price) {
        serviceManager.changeServicePrice(service, price);
    }

    public void printAllService() {
        serviceManager.printService();
    }

    public void showStayInfo() {
        stayInfoManager.printStayInfo();
    }

    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {

        if (room.getStatus() == RoomStatus.EMPTY) {
            RoomHistory newRoomHistory = new RoomHistory();

            newRoomHistory.setGuest(guest);
            newRoomHistory.setRoom(room);
            newRoomHistory.setCheckInDate(checkInDate);
            newRoomHistory.setCheckOutDate(checkOutDate);
            newRoomHistory.setStatus(RoomHistoryStatus.CHECKIN);

            stayInfoManager.addStayInfo(room.getRoomNumber() , new StayInfo(guest, checkInDate, checkOutDate));
            roomHistoryManager.addHistory(newRoomHistory);
            roomManager.changeRoomStatus(room, RoomStatus.OCCUPIED);
        } else {
            System.out.println("Заселить в комнату " + room.getRoomNumber() + " не представляется возможным. "
                    + "Статус комнаты = " + room.getStatus());
        }
    }

    public void checkOutGuestFromRoom(Guest guest, Room room) {
        if (room.getStatus() == RoomStatus.OCCUPIED) {
            stayInfoManager.deleteStayInfo(room.getRoomNumber());
            roomManager.changeRoomStatus(room, RoomStatus.EMPTY);
        } else {
            System.out.println("В комнате " + room.getRoomNumber() + " нет посетителей");
        }
    }
}





