package view;

import api.view.HotelManager;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import controllers.room_history.RoomHistoryManager;
import controllers.room_history.RoomHistoryManagerImpl;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import controllers.stay_info.StayInfoManager;
import controllers.stay_info.StayInfoManagerImpl;
import enums.RoomHistoryStatus;
import enums.RoomStatus;
import enums.ServiceType;
import models.*;

import java.time.LocalDate;
import java.util.List;

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

    RoomManager roomManagerImpl = new RoomManagerImpl();
    ServiceManager serviceManagerImpl = new ServiceManagerImpl();
    GuestManager guestManagerImpl = new GuestManagerImpl();
    RoomHistoryManager roomHistoryManagerImpl = new RoomHistoryManagerImpl();
    StayInfoManager stayInfoManagerImpl = new StayInfoManagerImpl();

    /**
     * ******************** Service ********************
     */
    @Override
    public void showServicesSortByPrice() {
        serviceManagerImpl.sortByPrice().stream().forEach(System.out::println);
    }

    @Override
    public void showServicesSortBySection() {
        serviceManagerImpl.sortBySection().stream().forEach(System.out::println);
    }

    @Override
    public Service getServiceByType(ServiceType serviceType) {
        return serviceManagerImpl.getServiceByType(serviceType);
    }

    @Override
    public void deleteService(Service service) {
        serviceManagerImpl.deleteService(service);
    }

    @Override
    public void showServiceSortByPriceOneGuest(List<Service> serviceList) {
        serviceManagerImpl.sortByPriceOneGuest(serviceList).stream().forEach(System.out::println);
    }

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
        if (stayInfoManagerImpl.searchGuestInTheRoom(guest, room)) {
            if (room.getStatus() == RoomStatus.OCCUPIED) {
                stayInfoManagerImpl.deleteStayInfo(room.getRoomNumber());
                roomManagerImpl.changeRoomStatus(room, RoomStatus.EMPTY);
            }
        } else {
            System.out.println("В комнате " + room.getRoomNumber() + " нет посетителей");
        }
    }

    /**
     * ******************** Guest ********************
     */
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

    @Override
    public Guest getGuestByName(String lastName) {
        return guestManagerImpl.getGuestByName(lastName);
    }

    @Override
    public void addServicesToGuest(Guest guest, Service service) {
        guestManagerImpl.addServicesToGuest(guest, service);
    }

    @Override
    public List<Service> getGuestServices(Guest guest) {
        return guestManagerImpl.getGuestServices(guest);
    }

    /**
     * ******************** Room ********************
     */
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
    public void showSortRoomsByCapacity() {
        roomManagerImpl.getSortedRoomsByCapacity().stream().forEach(System.out::println);
    }

    @Override
    public void showSortRoomsByStars() {
        roomManagerImpl.getSortedRoomsByStars().stream().forEach(System.out::println);
    }

    @Override
    public void showSortEmptyRoomsByPrice() {
        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByPrice()).stream().forEach(System.out::println);
    }

    @Override
    public void showSortEmptyRoomsByCapacity() {
        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByCapacity()).stream().forEach(System.out::println);
    }

    @Override
    public void showSortEmptyRoomsByStars() {
        roomManagerImpl.getFreeRooms(roomManagerImpl.getSortedRoomsByStars()).stream().forEach(System.out::println);
    }

    @Override
    public void totalCountEmptyRooms() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("total Count Empty Rooms: ");
        stringBuilder.append(roomManagerImpl.totalCountEmptyRooms());
        System.out.println(stringBuilder.toString());
    }

    @Override
    public Room getRoomByNumber(Integer roomNumber) {
        return roomManagerImpl.getRoomByNumber(roomNumber);
    }

    @Override
    public void showEmptyRooms() {
        if (roomManagerImpl.getEmptyRooms() == null) {
            System.out.println("Нет свободных комнат");
        } else {
            roomManagerImpl.getEmptyRooms().stream().forEach(System.out::println);
        }
    }

    /**
     * ******************** StayInfo ********************
     */

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

    @Override
    public boolean containsGuestInTheRoom(Guest guest, Room room) {
        return stayInfoManagerImpl.searchGuestInTheRoom(guest, room);
    }

    @Override
    public double getBillForRoomAndGuest(Guest guest, Room room) {
        return stayInfoManagerImpl.getBillForRoomAndGuest(guest, room);
    }

    @Override
    public double getBillServiceOneGuest(Guest guest) {
        return stayInfoManagerImpl.getBillServiceOneGuest(guest);
    }

    /**
     * ******************** Room History ********************
     */
    @Override
    public void printAllRoomHistories() {
        roomHistoryManagerImpl.printRoomHistories();
    }
}



