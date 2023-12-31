package controllers;

import api.controllers.StayInfoManager;
import models.Guest;
import models.Room;
import models.Service;
import models.StayInfo;
import storages.StayInfoStorageImpl;
import utils.Util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StayInfoManagerImpl implements StayInfoManager {

    @Override
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo) {
        StayInfoStorageImpl.getInstance().addStayInfo(roomNumber, stayInfo);
    }

    @Override
    public void deleteStayInfo(Integer roomNumber) {
        StayInfoStorageImpl.getInstance().deleteStayInfo(roomNumber);
    }

    @Override
    public void printStayInfo() {
        for (Map.Entry<Integer, StayInfo> entry : StayInfoStorageImpl.getInstance().getInfoStorage().entrySet()) {
            Integer room = entry.getKey();
            StayInfo stayInfo = entry.getValue();

            System.out.println("Room: " + room);
            System.out.println("Guest: " + stayInfo.getGuest().getLastName());
            System.out.println("Check-in date: " + stayInfo.getCheckInDate());
            System.out.println("Check-out date: " + stayInfo.getCheckOutDate());
            System.out.println("--------------------------------------");
        }
    }

    @Override
    public List<Integer> getFreeRoomsByDate(LocalDate date) {
        return StayInfoStorageImpl.getInstance().getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getValue().getCheckInDate().isAfter(date)
                        || entry.getValue().getCheckOutDate().isBefore(date)
                        || entry.getValue().getCheckInDate().isEqual(date)
                        || entry.getValue().getCheckOutDate().isEqual(date))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public double getPayAmountForRoom(Room room) {
        return StayInfoStorageImpl.getInstance().getInfoStorage().entrySet().stream()
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
                StayInfoStorageImpl.getInstance().getInfoStorage();
        return infoStorage.entrySet().stream()
                .skip(Math.max(0, infoStorage.size() - 3))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    @Override
    public boolean searchGuestInTheRoom(Guest guest, Room room) {
        return StayInfoStorageImpl.getInstance().getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(room.getRoomNumber()))
                .map(Map.Entry::getValue)
                .anyMatch(stayInfo -> stayInfo.getGuest().getLastName().equals(guest.getLastName()));
    }

    @Override
    public double getBillForRoomAndGuest(Guest guest, Room room) {
        return StayInfoStorageImpl.getInstance().getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(room.getRoomNumber()) && entry.getValue().getGuest().equals(guest))
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

//    public double getBillServiceOneGuest(Guest guest) {
//        return StayInfoStorageImpl.getInstance().getInfoStorage().values().stream()
//                .filter(stayInfo -> stayInfo.getGuest().equals(guest))
//                .mapToDouble(Util::calculateServicesCost)
//                .sum();
//    }

    public double getBillServiceOneGuest(Guest guest) {
        return StayInfoStorageImpl.getInstance().getInfoStorage().values().stream()
                .filter(stayInfo -> stayInfo.getGuest().equals(guest))
                .mapToDouble(this::calculateServicesCost)
                .sum();
    }

    private double calculateServicesCost(StayInfo stayInfo) {
        return stayInfo.getGuest().getServices().stream()
                .mapToDouble(Service::getPrice)
                .sum();
    }
}

