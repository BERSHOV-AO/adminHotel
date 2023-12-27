package api.storages;

import models.StayInfo;

import java.util.Map;

public interface StayInfoStorage {
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo);

    public void deleteStayInfo(Integer roomNumber);

    public Map<Integer, StayInfo> getInfoStorage();
}
