package storages;

import models.StayInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class StayInfoStorage {

    private Map<Integer, StayInfo> infoStorage = new LinkedHashMap<>();

    public void addStayInfo(Integer roomNumber, StayInfo stayInfo) {
        infoStorage.put(roomNumber, stayInfo);
    }

    public void deleteStayInfo(Integer roomNumber) {
        infoStorage.remove(roomNumber);
    }

    public Map<Integer, StayInfo> getInfoStorage() {
        return infoStorage;
    }
}
