package ru.senla.repository.stay_info;

import ru.senla.entities.Guest;
import ru.senla.entities.Room;
import ru.senla.entities.Service;
import ru.senla.entities.StayInfo;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IStayInfoRepository {
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo);

    public void setStayInfo(Map<Integer, StayInfo> infoStorage);

    public void deleteStayInfo(Integer roomNumber);

    public Map<Integer, StayInfo> getMapStayInfo();

    public List<Integer> getFreeRoomsByDate(LocalDate date);

    public double getPayAmountForRoom(Room room);

    public LinkedHashMap<Integer, StayInfo> getLastThreeGuests();

    public boolean containsGuestInTheRoom(Guest guest, Room room);

    public double getBillForRoomGuest(Guest guest, Room room);

    public double getBillForRoomAndGuest(Guest guest, Room room);

    public double getBillServiceOneGuest(Guest guest);

    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate);

    public void checkOutGuestFromRoom(Guest guest, Room room);

    public boolean checkStayInfIDExists(int stayInfoId);

    public List<Service> getListStayInfoOneGuest(Guest guest);

    public double getBillServiceByGuest(Guest guest);

    public void exportStayInfoToFileCSV();

    public boolean isMapStayInfoEmpty();

    public void serializerStayInfo();

    public void deserializeStayInfo();
}
