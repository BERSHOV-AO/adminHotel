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

    //------------------ Guest -----------------------

    public void addGuest(Guest guest) {
        guestManager.addOnGuest(guest);
    }

    public void deleteGuest(Guest guest) {
        guestManager.deleteGuest(guest);
    }

    public void printAllGuest() {
        guestManager.printGuest();
    }


    //------------------- Room -----------------------

    public void createRoom(Room room) {
        roomManager.addRoom(room);
    }

    public void changeRoomStatus(Room room, RoomStatus roomStatus) {
        roomManager.changeRoomStatus(room, roomStatus);
    }

    // Изменить цену номера
    public void changeRoomPrice(Room room, double price) {
        roomManager.changeRoomPrice(room, price);
    }

    public void printAllRooms() {
        roomManager.printRooms();
    }

    //--------------------- Room History ----------------------


    public void printAllRoomHistories() {
        roomHistoryManager.printRoomHistories();
    }

    // -------------------- Service ---------------------
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

    //----------------------------------------------------
    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {

        if (room.getStatus() == RoomStatus.EMPTY) {
            RoomHistory newRoomHistory = new RoomHistory();

            newRoomHistory.setGuest(guest);
            newRoomHistory.setRoom(room);
            newRoomHistory.setCheckInDate(checkInDate);
            newRoomHistory.setCheckOutDate(checkOutDate);
            newRoomHistory.setStatus(RoomHistoryStatus.CHECKIN);

            stayInfoManager.addStayInfo(room.getRoomNumber(), new StayInfo(guest, checkInDate, checkOutDate));


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





