package managers;

import models.Room;
import models.StayInfo;
import storages.StayInfoStorage;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StayInfoManager {

    StayInfoStorage stayInfoStorage = new StayInfoStorage();

    public void addStayInfo(Integer roomNumber, StayInfo stayInfo) {
        stayInfoStorage.addStayInfo(roomNumber, stayInfo);
    }

    public void deleteStayInfo(Integer roomNumber) {
        stayInfoStorage.deleteStayInfo(roomNumber);
    }

    public void printStayInfo() {
        for (Map.Entry<Integer, StayInfo> entry : stayInfoStorage.getInfoStorage().entrySet()) {
            Integer room = entry.getKey();
            StayInfo stayInfo = entry.getValue();

            System.out.println("Room: " + room);
            System.out.println("Guest: " + stayInfo.getGuest().getLastName());
            System.out.println("Check-in date: " + stayInfo.getCheckInDate());
            System.out.println("Check-out date: " + stayInfo.getCheckOutDate());
            System.out.println("--------------------------------------");
        }
    }

    public List<Integer> getFreeRoomsByDate(LocalDate date) {
        return stayInfoStorage.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getValue().getCheckInDate().isAfter(date)
                        || entry.getValue().getCheckOutDate().isBefore(date)
                        || entry.getValue().getCheckInDate().isEqual(date)
                        || entry.getValue().getCheckOutDate().isEqual(date))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public double getPayAmountForRoom(Room room) {
        return stayInfoStorage.getInfoStorage().entrySet().stream()
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

    public LinkedHashMap<Integer, StayInfo> getLastThreeGuests() {
        LinkedHashMap<Integer, StayInfo> infoStorage = (LinkedHashMap<Integer, StayInfo>) stayInfoStorage.getInfoStorage();
        return infoStorage.entrySet().stream()
                .skip(Math.max(0, infoStorage.size() - 3))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}





