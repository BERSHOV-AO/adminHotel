package storages;

import api.storages.StayInfoStorage;
import models.StayInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class StayInfoStorageImpl implements StayInfoStorage {

    private Map<Integer, StayInfo> infoStorage = new LinkedHashMap<>();

    private static StayInfoStorageImpl instance;

    private StayInfoStorageImpl() {
    }

    public static StayInfoStorageImpl getInstance() {
        if (instance == null) {
            instance = new StayInfoStorageImpl();
        }
        return instance;
    }

    @Override
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo) {
        infoStorage.put(roomNumber, stayInfo);
    }

    @Override
    public void deleteStayInfo(Integer roomNumber) {
        infoStorage.remove(roomNumber);
    }

    @Override
    public Map<Integer, StayInfo> getInfoStorage() {
        return infoStorage;
    }
}
