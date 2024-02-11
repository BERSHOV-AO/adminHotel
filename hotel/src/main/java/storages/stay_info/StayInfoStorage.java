package storages.stay_info;

import models.StayInfo;

import java.util.Map;

public interface StayInfoStorage {
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo);

    public void deleteStayInfo(Integer roomNumber);

    public Map<Integer, StayInfo> getInfoStorage();

    public void setStayInfo(Map<Integer, StayInfo> infoStorage);
}
