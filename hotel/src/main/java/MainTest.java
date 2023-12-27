import enums.RoomStatus;
import enums.ServiceType;
import models.Guest;
import models.Room;
import models.Service;
import view.HotelManagerImpl;

import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {

//        HotelManagerImpl hotelManagerImpl = new HotelManagerImpl();
        // заглушка
        HotelManagerImpl hotelManagerImpl = HotelManagerImpl.getInstance();

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

        hotelManagerImpl.createRoom(room1);
        hotelManagerImpl.createRoom(room2);
        hotelManagerImpl.createRoom(room3);
        hotelManagerImpl.createRoom(room4);
        hotelManagerImpl.createRoom(room5);
        hotelManagerImpl.createRoom(room6);
        hotelManagerImpl.createRoom(room7);
        hotelManagerImpl.createRoom(room8);
        hotelManagerImpl.createRoom(room9);
        hotelManagerImpl.createRoom(room10);

        hotelManagerImpl.printAllRooms();

        System.out.println("--changeRoomStatus--");
        // changeRoomStatus
        hotelManagerImpl.changeRoomStatus(room1, RoomStatus.UNDER_REPAIR);
        hotelManagerImpl.changeRoomStatus(room2, RoomStatus.SERVICE);
        hotelManagerImpl.printAllRooms();

        System.out.println("--changeRoomPrice--");
        // changeRoomPrice
        hotelManagerImpl.changeRoomPrice(room3, 3000);
        hotelManagerImpl.changeRoomPrice(room4, 2800);
        hotelManagerImpl.printAllRooms();

        // printDetailsOfRoom
        hotelManagerImpl.printDetailsOfRoom(room2);

        System.out.println("--sortRoomsByPrice--");
        // sortRoomsByPrice
        hotelManagerImpl.sortRoomsByPrice();
        System.out.println("--sortRoomsByCapacity--");
        // sortRoomsByCapacity
        hotelManagerImpl.sortRoomsByCapacity();
        System.out.println("--sortRoomsByStars--");
        // sortRoomsByStars
        hotelManagerImpl.sortRoomsByStars();
        // sortedEmptyRoomsByStars
        System.out.println("--sortEmptyRoomsByPrice--");
        hotelManagerImpl.sortEmptyRoomsByPrice();
        // sortEmptyRoomsByCapacity
        System.out.println("--sortEmptyRoomsByCapacity--");
        hotelManagerImpl.sortEmptyRoomsByCapacity();
        // sortEmptyRoomsByStars
        System.out.println("--sortEmptyRoomsByStars--");
        hotelManagerImpl.sortEmptyRoomsByStars();
        hotelManagerImpl.totalCountEmptyRooms();

        System.out.println("------------------------------SERVICE--------------------------------");
        Service service1 = new Service(ServiceType.BREAKFAST, 150);
        Service service2 = new Service(ServiceType.LUNCH, 100);
        Service service3 = new Service(ServiceType.DINNER, 250);
        Service service4 = new Service(ServiceType.LAUNDRY, 120);

        hotelManagerImpl.createService(service1);
        hotelManagerImpl.createService(service2);
        hotelManagerImpl.createService(service3);
        hotelManagerImpl.createService(service4);
        hotelManagerImpl.createService(service1);
        hotelManagerImpl.createService(service3);
        hotelManagerImpl.printAllService();

        System.out.println("--showServicesSortByPrice--");
        hotelManagerImpl.showServicesSortByPrice();

        System.out.println("--showServicesSortBySection--");
        hotelManagerImpl.showServicesSortBySection();

        System.out.println("--changeServiceOnPrice--");
        hotelManagerImpl.changeServiceOnPrice(service1, 222);
        hotelManagerImpl.changeServiceOnPrice(service2, 144);
        hotelManagerImpl.printAllService();

        System.out.println("--------------------------------GUEST---------------------------------");
        Guest guest1 = new Guest("Alex");
        Guest guest2 = new Guest("Max");
        Guest guest3 = new Guest("Svetlana");
        Guest guest4 = new Guest("Sergey");
        Guest guest5 = new Guest("Irina");
        Guest guest6 = new Guest("Aleksey");

        hotelManagerImpl.addGuest(guest1);
        hotelManagerImpl.addGuest(guest2);
        hotelManagerImpl.addGuest(guest3);
        hotelManagerImpl.addGuest(guest4);
        hotelManagerImpl.addGuest(guest5);
        hotelManagerImpl.addGuest(guest6);

        hotelManagerImpl.printAllGuest();

        System.out.println("--CheckInGuestInRoom--");
        hotelManagerImpl.checkInGuestInRoom(guest1, room1, LocalDate.of(2023, 12, 05),
                LocalDate.of(2023, 12, 10));
        hotelManagerImpl.checkInGuestInRoom(guest2, room3, LocalDate.of(2023, 12, 11),
                LocalDate.of(2023, 12, 17));
        hotelManagerImpl.checkInGuestInRoom(guest3, room4, LocalDate.of(2023, 12, 07),
                LocalDate.of(2023, 12, 21));
        hotelManagerImpl.checkInGuestInRoom(guest4, room5, LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 12, 13));
        hotelManagerImpl.checkInGuestInRoom(guest5, room6, LocalDate.of(2023, 12, 16),
                LocalDate.of(2023, 12, 28));
        hotelManagerImpl.checkInGuestInRoom(guest6, room7, LocalDate.of(2023, 12, 15),
                LocalDate.of(2023, 12, 23));

        hotelManagerImpl.showStayInfo();

        hotelManagerImpl.sortGuestsByName();

        System.out.println("--sortGuestsByName--");
        hotelManagerImpl.sortGuestsByName();

        System.out.println("--showFreeRoomsByDate--");
        // showFreeRoomsByDate
        hotelManagerImpl.showFreeRoomsByDate(LocalDate.of(2023, 12, 12));

        System.out.println("--showPayAmountForRoom--");
        // showPayAmountForRoom
        hotelManagerImpl.showPayAmountForRoom(room6);
        hotelManagerImpl.showPayAmountForRoom(room7);

        hotelManagerImpl.showStayInfo();

        System.out.println("--showLastThreeGuests--");
        // showLastThreeGuests
        hotelManagerImpl.printLastThreeGuests();

        // Room details
        hotelManagerImpl.printDetailsOfRoom(room7);

        /**
         * Отдельно сохраняем историю
         */
        System.out.println("--printAllRoomHistories--");
        hotelManagerImpl.printAllRoomHistories();
    }
}
