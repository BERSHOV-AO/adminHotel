package ru.senla.repository.stay_info;

import ru.senla.datasource.stay_info.IStayInfoDatasource;
import ru.senla.datasource.stay_info.StayInfoDatasourceImpl;
import ru.senla.entities.*;
import ru.senla.enums.RoomHistoryStatus;
import ru.senla.enums.RoomStatus;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.room_history.IRoomsHistoryRepository;
import ru.senla.repository.room_history.RoomsHistoryRepositoryImpl;
import ru.senla.utils.RandomNumber;
import ru.senla.utils.csv_utils.RoomHistoryExporter;
import ru.senla.utils.csv_utils.StayInfoExporter;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StayInfoRepositoryImpl implements IStayInfoRepository {

    IStayInfoDatasource stayInfoDatasource = StayInfoDatasourceImpl.getInstance();
    IRoomsHistoryRepository roomsHistoryRepository = RoomsHistoryRepositoryImpl.getInstance();
    IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    private static StayInfoRepositoryImpl instance;

    private StayInfoRepositoryImpl() {
    }

    public static StayInfoRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new StayInfoRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo) {
        stayInfoDatasource.addStayInfo(roomNumber, stayInfo);
    }

    @Override
    public void setStayInfo(Map<Integer, StayInfo> infoStorage) {
        stayInfoDatasource.setStayInfo(infoStorage);
    }

    @Override
    public void deleteStayInfo(Integer roomNumber) {
        stayInfoDatasource.deleteStayInfo(roomNumber);
    }

    @Override
    public Map<Integer, StayInfo> getMapStayInfo() {
        return stayInfoDatasource.getInfoStorage();
    }

    @Override
    public List<Integer> getFreeRoomsByDate(LocalDate date) {
        return stayInfoDatasource.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getValue().getCheckInDate().isAfter(date)
                        || entry.getValue().getCheckOutDate().isBefore(date)
                        || entry.getValue().getCheckInDate().isEqual(date)
                        || entry.getValue().getCheckOutDate().isEqual(date))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public double getPayAmountForRoom(Room room) {
        return stayInfoDatasource.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(room.getRoomNumber()))
                .findFirst()
                .map(entry -> {
                    LocalDate checkInDate = entry.getValue().getCheckInDate();
                    LocalDate checkOutDate = entry.getValue().getCheckOutDate();
                    int duration = (int) checkInDate.until(checkOutDate).getDays();
                    double pricePerNight = room.getPrice();
                    return duration * pricePerNight;
                })
                .orElse(0.0);
    }

    @Override
    public LinkedHashMap<Integer, StayInfo> getLastThreeGuests() {
        LinkedHashMap<Integer, StayInfo> infoStorage = (LinkedHashMap<Integer, StayInfo>)
                stayInfoDatasource.getInfoStorage();
        return infoStorage.entrySet().stream()
                .skip(Math.max(0, infoStorage.size() - 3))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    @Override
    public boolean containsGuestInTheRoom(Guest guest, Room room) {
        return stayInfoDatasource.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(room.getRoomNumber()))
                .map(Map.Entry::getValue)
                .anyMatch(stayInfo -> stayInfo.getGuest().getLastName().equals(guest.getLastName()));
    }

    @Override
    public double getBillForRoomAndGuest(Guest guest, Room room) {
        return stayInfoDatasource.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(room.getRoomNumber()) && entry.getValue().getGuest()
                        .equals(guest))
                .findFirst()
                .map(entry -> {
                    LocalDate checkInDate = entry.getValue().getCheckInDate();
                    LocalDate checkOutDate = entry.getValue().getCheckOutDate();
                    int duration = (int) checkInDate.until(checkOutDate).getDays();
                    double pricePerNight = room.getPrice();
                    return duration * pricePerNight;
                })
                .orElse(0.0);
    }

    @Override
    public double getBillForRoomGuest(Guest guest, Room room) {
        Map<Integer, StayInfo> infoStorage = stayInfoDatasource.getInfoStorage();
        StayInfo stayInfo = infoStorage.get(room.getRoomNumber());
        Period period = Period.between(stayInfo.getCheckInDate(),
                stayInfo.getCheckOutDate());
        int days = period.getDays();
        double payment = room.getPrice() * days;
        return payment;
    }

    @Override
    public double getBillServiceOneGuest(Guest guest) {
        Map<Integer, StayInfo> infoStorage = stayInfoDatasource.getInfoStorage();
        double totalBill = 0.0;

        for (StayInfo stayInfo : infoStorage.values()) {
            if (stayInfo.getGuest().getLastName().equals(guest.getLastName())) {
                List<Service> services = stayInfo.getGuest().getServices();
                if (services.size() != 0) {
                    for (Service service : services) {
                        totalBill += service.getPrice();
                    }
                }
            }
        }
        System.out.println("totalBill: " + totalBill);
        return totalBill;
    }

    @Override
    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {

        if (room.getStatus() == RoomStatus.EMPTY) {
            RoomHistory newRoomHistory = new RoomHistory();

            newRoomHistory.setId(RandomNumber.getRandomID());
            newRoomHistory.setGuest(guest);
            newRoomHistory.setRoom(room);
            newRoomHistory.setCheckInDate(checkInDate);
            newRoomHistory.setCheckOutDate(checkOutDate);
            newRoomHistory.setStatus(RoomHistoryStatus.CHECKIN);

            addStayInfo(room.getRoomNumber(), new StayInfo(guest, checkInDate, checkOutDate));
            roomsHistoryRepository.addHistory(newRoomHistory);
            room.addHistoriesRoom(newRoomHistory);
            roomsRepository.changeRoomStatus(room, RoomStatus.OCCUPIED);
            RoomHistoryExporter.exportOneRoomsHistory(newRoomHistory);
        } else {
            System.out.println("Заселить в комнату " + room.getRoomNumber() + " не представляется возможным. "
                    + "Статус комнаты = " + room.getStatus());
        }
    }

    @Override
    public void checkOutGuestFromRoom(Guest guest, Room room) {

        if (containsGuestInTheRoom(guest, room)) {
            RoomHistory roomHistory = new RoomHistory();
            if (room.getStatus() == RoomStatus.OCCUPIED) {
                deleteStayInfo(room.getRoomNumber());
                roomsRepository.changeRoomStatus(room, RoomStatus.EMPTY);
                roomHistory = roomsHistoryRepository.getRoomHistoryByGuestAndRoom(guest, room);
                roomHistory.setId(RandomNumber.getRandomID());
                roomHistory.setStatus(RoomHistoryStatus.CHECKOUT);
                roomsHistoryRepository.addHistory(roomHistory);
                RoomHistoryExporter.exportOneRoomsHistory(roomHistory);
            }
        } else {
            System.out.println("В комнате " + room.getRoomNumber() + " нет посетителей");
        }
    }


    @Override
    public boolean checkStayInfIDExists(int stayInfoId) {
        return stayInfoDatasource.getInfoStorage().values().stream()
                .anyMatch(stayInfo -> stayInfo.getId() == stayInfoId);
    }


    @Override
    public List<Service> getListStayInfoOneGuest(Guest guest) {
        List<Service> srvicesList = new ArrayList<>();
        Map<Integer, StayInfo> infoStorage = stayInfoDatasource.getInfoStorage();

        for (StayInfo stayInfo : infoStorage.values()) {
            if (stayInfo.getGuest().getLastName().equals(guest.getLastName())) {
                srvicesList = stayInfo.getGuest().getServices();
            }
        }
        return srvicesList;
    }

    @Override
    public double getBillServiceByGuest(Guest guest) {
        List<Service> srvicesList = getListStayInfoOneGuest(guest);
        double allPrice = 0.0;
        for (Service service : srvicesList) {
            allPrice += service.getPrice();
        }
        return allPrice;
    }

    @Override
    public void exportStayInfoToFileCSV() {
        StayInfoExporter.exportStayInfo(stayInfoDatasource.getInfoStorage());
    }

    @Override
    public boolean isMapStayInfoEmpty() {
        return stayInfoDatasource.getInfoStorage().isEmpty();
    }
}
