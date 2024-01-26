import enums.RoomStatus;
import enums.ServiceType;
import managers.HotelManager;
import models.Guest;
import models.Room;
import models.Service;

import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {

        HotelManager hotelManager = new HotelManager();

        System.out.println("------------------------------ROOM--------------------------------");
        Room room1 = new Room(1, 1, 1000, 3, RoomStatus.EMPTY);
        Room room2 = new Room(2, 4, 2000, 2, RoomStatus.EMPTY);
        Room room3 = new Room(3, 3, 1800, 1, RoomStatus.EMPTY);
        Room room4 = new Room(4, 5, 2100, 3, RoomStatus.EMPTY);
        Room room5 = new Room(5, 1, 2300, 1, RoomStatus.EMPTY);
        Room room6 = new Room(6, 4, 1800, 2, RoomStatus.EMPTY);
        Room room7 = new Room(7, 5, 1700, 4, RoomStatus.EMPTY);
        Room room8 = new Room(8, 5, 2500, 1, RoomStatus.EMPTY);
        Room room9 = new Room(9, 1, 3000, 3, RoomStatus.EMPTY);
        Room room10 = new Room(10, 2, 2200, 2, RoomStatus.EMPTY);

        hotelManager.createRoom(room1);
        hotelManager.createRoom(room2);
        hotelManager.createRoom(room3);
        hotelManager.createRoom(room4);
        hotelManager.createRoom(room5);
        hotelManager.createRoom(room6);
        hotelManager.createRoom(room7);
        hotelManager.createRoom(room8);
        hotelManager.createRoom(room9);
        hotelManager.createRoom(room10);

        hotelManager.printAllRooms();

        System.out.println("--changeRoomStatus--");
        // changeRoomStatus
        hotelManager.changeRoomStatus(room1, RoomStatus.UNDER_REPAIR);
        hotelManager.changeRoomStatus(room2, RoomStatus.SERVICE);
        hotelManager.printAllRooms();

        System.out.println("--changeRoomPrice--");
        // changeRoomPrice
        hotelManager.changeRoomPrice(room3, 3000);
        hotelManager.changeRoomPrice(room4, 2800);
        hotelManager.printAllRooms();

        // printDetailsOfRoom
        hotelManager.printDetailsOfRoom(room2);

        System.out.println("--sortRoomsByPrice--");
        // sortRoomsByPrice
        hotelManager.sortRoomsByPrice();
        System.out.println("--sortRoomsByCapacity--");
        // sortRoomsByCapacity
        hotelManager.sortRoomsByCapacity();
        System.out.println("--sortRoomsByStars--");
        // sortRoomsByStars
        hotelManager.sortRoomsByStars();
        // sortedEmptyRoomsByStars
        System.out.println("--sortEmptyRoomsByPrice--");
        hotelManager.sortEmptyRoomsByPrice();
        // sortEmptyRoomsByCapacity
        System.out.println("--sortEmptyRoomsByCapacity--");
        hotelManager.sortEmptyRoomsByCapacity();
        // sortEmptyRoomsByStars
        System.out.println("--sortEmptyRoomsByStars--");
        hotelManager.sortEmptyRoomsByStars();
        hotelManager.totalCountEmptyRooms();

        System.out.println("------------------------------SERVICE--------------------------------");
        Service service1 = new Service(ServiceType.BREAKFAST, 150);
        Service service2 = new Service(ServiceType.LUNCH, 100);
        Service service3 = new Service(ServiceType.DINNER, 250);
        Service service4 = new Service(ServiceType.LAUNDRY, 120);

        hotelManager.createService(service1);
        hotelManager.createService(service2);
        hotelManager.createService(service3);
        hotelManager.createService(service4);
        hotelManager.createService(service1);
        hotelManager.createService(service3);
        hotelManager.printAllService();

        System.out.println("--showServicesSortByPrice--");
        hotelManager.showServicesSortByPrice();

        System.out.println("--showServicesSortBySection--");
        hotelManager.showServicesSortBySection();

        System.out.println("--changeServiceOnPrice--");
        hotelManager.changeServiceOnPrice(service1, 222);
        hotelManager.changeServiceOnPrice(service2, 144);
        hotelManager.printAllService();

        System.out.println("--------------------------------GUEST---------------------------------");
        Guest guest1 = new Guest("Alex");
        Guest guest2 = new Guest("Max");
        Guest guest3 = new Guest("Svetlana");
        Guest guest4 = new Guest("Sergey");
        Guest guest5 = new Guest("Irina");
        Guest guest6 = new Guest("Aleksey");

        hotelManager.addGuest(guest1);
        hotelManager.addGuest(guest2);
        hotelManager.addGuest(guest3);
        hotelManager.addGuest(guest4);
        hotelManager.addGuest(guest5);
        hotelManager.addGuest(guest6);

        hotelManager.printAllGuest();

        System.out.println("--CheckInGuestInRoom--");
        hotelManager.checkInGuestInRoom(guest1, room1, LocalDate.of(2023, 12, 05),
                LocalDate.of(2023, 12, 10));
        hotelManager.checkInGuestInRoom(guest2, room3, LocalDate.of(2023, 12, 11),
                LocalDate.of(2023, 12, 17));
        hotelManager.checkInGuestInRoom(guest3, room4, LocalDate.of(2023, 12, 07),
                LocalDate.of(2023, 12, 21));
        hotelManager.checkInGuestInRoom(guest4, room5, LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 12, 13));
        hotelManager.checkInGuestInRoom(guest5, room6, LocalDate.of(2023, 12, 16),
                LocalDate.of(2023, 12, 28));
        hotelManager.checkInGuestInRoom(guest6, room7, LocalDate.of(2023, 12, 15),
                LocalDate.of(2023, 12, 23));

        hotelManager.showStayInfo();

        hotelManager.sortGuestsByName();

        System.out.println("--sortGuestsByName--");
        hotelManager.sortGuestsByName();

        System.out.println("--showFreeRoomsByDate--");
        // showFreeRoomsByDate
        hotelManager.showFreeRoomsByDate(LocalDate.of(2023, 12, 12));

        System.out.println("--showPayAmountForRoom--");
        // showPayAmountForRoom
        hotelManager.showPayAmountForRoom(room6);
        hotelManager.showPayAmountForRoom(room7);

        hotelManager.showStayInfo();

        System.out.println("--showLastThreeGuests--");
        // showLastThreeGuests
        hotelManager.printLastThreeGuests();

        // Room details
        hotelManager.printDetailsOfRoom(room7);

        /**
         * Отдельно сохраняем историю
         */
        System.out.println("--printAllRoomHistories--");
        hotelManager.printAllRoomHistories();
    }
}
