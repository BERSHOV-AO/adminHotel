package utils;

import models.StayInfo;
import storages.stay_info.StayInfoStorageImpl;

import java.util.Map;

public class Printer {
    public Printer() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printStayInfo(Map<Integer, StayInfo> stayInfoMap){
        System.out.println("Information about room occupancy");
        for (Map.Entry<Integer, StayInfo> entry : stayInfoMap.entrySet()) {
            Integer room = entry.getKey();
            StayInfo stayInfo = entry.getValue();

            System.out.println("Room: " + room);
            System.out.println("Guest: " + stayInfo.getGuest().getLastName());
            System.out.println("Check-in date: " + stayInfo.getCheckInDate());
            System.out.println("Check-out date: " + stayInfo.getCheckOutDate());
            System.out.println("--------------------------------------");
        }
    }
}
