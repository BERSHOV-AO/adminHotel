package ru.senla.stay_info;

import ru.senla.entities.StayInfo;

import java.util.Map;

public interface IStayInfoService {
    public Map<Integer, StayInfo> getMapStayInfo();

    public String getBillForIdRoomAndIdGuest(int guestId, int roomId);

    public String exportStayInfoToFileCSV();

    public Map<Integer, StayInfo> printStayInfo();
}
