package api.view;

import enums.RoomStatus;
import enums.ServiceType;
import models.Guest;
import models.Room;
import models.Service;

import java.time.LocalDate;
import java.util.List;

public interface HotelManager {

    /**
     * ******************** Service ********************
     */
    public void showServicesSortByPrice();

    public void showServicesSortBySection();

    public Service getServiceByType(ServiceType serviceType);

    public void deleteService(Service service);

    public void showServiceSortByPriceOneGuest(List<Service> serviceList);

    public void createService(Service service);

    public void changeServiceOnPrice(Service service, double price);

    public void printAllService();

    public void showStayInfo();

    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate);

    public void checkOutGuestFromRoom(Guest guest, Room room);

    /**
     * ******************** Guest ********************
     */
    public void addGuest(Guest guest);

    public void deleteGuest(Guest guest);

    public void printAllGuest();

    public void sortGuestsByName();

    public Guest getGuestByName(String lastName);

    public void addServicesToGuest(Guest guest, Service service);

    public List<Service> getGuestServices(Guest guest);

    /**
     * ******************** Room ********************
     */

    public void createRoom(Room room);

    public void changeRoomStatus(Room room, RoomStatus roomStatus);

    public void changeRoomPrice(Room room, double price);

    public void printAllRooms();

    public void printDetailsOfRoom(Room room);

    public void sortRoomsByPrice();

    public void showSortRoomsByCapacity();

    public void showSortRoomsByStars();

    public void showSortEmptyRoomsByPrice();

    public void showSortEmptyRoomsByCapacity();

    public void showSortEmptyRoomsByStars();

    public void totalCountEmptyRooms();

    public Room getRoomByNumber(Integer roomNumber);

    public void showEmptyRooms();

    /**
     * ******************** StayInfo ********************
     */
    public void showFreeRoomsByDate(LocalDate date);

    public void showPayAmountForRoom(Room room);

    public void printLastThreeGuests();

    public boolean containsGuestInTheRoom(Guest guest, Room room);

    public double getBillForRoomAndGuest(Guest guest, Room room);

    public double getBillServiceOneGuest(Guest guest);

    /**
     * ******************** Room History ********************
     */
    public void printAllRoomHistories();
}
