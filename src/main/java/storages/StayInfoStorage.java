package storages;

import models.StayInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StayInfoStorage {

    private Map<Integer, StayInfo> infoStorage = new ConcurrentHashMap<>();

    public void addStayInfo(int roomNumber, StayInfo stayInfo) {
        infoStorage.put(roomNumber, stayInfo);
    }

    public void deleteStayInfo(int roomNumber) {
        infoStorage.remove(roomNumber);
    }

    public Map<Integer, StayInfo> getInfoStorage() {
        return infoStorage;
    }


}
