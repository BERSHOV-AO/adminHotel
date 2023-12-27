package storages;

import api.storages.RoomHistoryStorage;
import models.RoomHistory;

import java.util.ArrayList;
import java.util.List;

public class RoomHistoryStorageImpl implements RoomHistoryStorage {

    private List<RoomHistory> roomHistories = new ArrayList<>();

    private static RoomHistoryStorageImpl instance;

    private RoomHistoryStorageImpl() {
    }

    public static RoomHistoryStorageImpl getInstance() {
        if (instance == null) {
            instance = new RoomHistoryStorageImpl();
        }
        return instance;
    }

    @Override
    public void addRoomHistory(RoomHistory history) {
        roomHistories.add(history);
    }

    @Override
    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
    }
}
