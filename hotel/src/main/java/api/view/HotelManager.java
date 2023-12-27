package api.view;

import enums.RoomStatus;
import models.Guest;
import models.Room;
import models.Service;

import java.time.LocalDate;

public interface HotelManager {

    // Service
    public void showServicesSortByPrice();

    public void showServicesSortBySection();

    // Guest
    public void addGuest(Guest guest);

    public void deleteGuest(Guest guest);

    public void printAllGuest();

    public void sortGuestsByName();

    // Room
    public void createRoom(Room room);

    public void changeRoomStatus(Room room, RoomStatus roomStatus);

    public void changeRoomPrice(Room room, double price);

    public void printAllRooms();

    public void printDetailsOfRoom(Room room);

    public void sortRoomsByPrice();

    public void sortRoomsByCapacity();

    public void sortRoomsByStars();

    public void sortEmptyRoomsByPrice();

    public void sortEmptyRoomsByCapacity();

    public void sortEmptyRoomsByStars();

    public void totalCountEmptyRooms();

    public void showFreeRoomsByDate(LocalDate date);

    public void showPayAmountForRoom(Room room);

    public void printLastThreeGuests();

    // Room History
    public void printAllRoomHistories();

    // Service
    public void createService(Service service);

    public void changeServiceOnPrice(Service service, double price);

    public void printAllService();

    public void showStayInfo();

    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate);

    public void checkOutGuestFromRoom(Guest guest, Room room);
}
