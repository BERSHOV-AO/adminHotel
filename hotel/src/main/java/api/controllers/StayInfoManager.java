package api.controllers;

import models.Room;
import models.StayInfo;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public interface StayInfoManager {

    public void addStayInfo(Integer roomNumber, StayInfo stayInfo);

    public void deleteStayInfo(Integer roomNumber);

    public void printStayInfo();

    public List<Integer> getFreeRoomsByDate(LocalDate date);

    public double getPayAmountForRoom(Room room);

    public LinkedHashMap<Integer, StayInfo> getLastThreeGuests();
}
