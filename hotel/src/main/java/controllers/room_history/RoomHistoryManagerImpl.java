package controllers.room_history;

import models.RoomHistory;
import storages.room_history.RoomHistoryStorageImpl;

import java.util.List;

public class RoomHistoryManagerImpl implements RoomHistoryManager {

    private static RoomHistoryManagerImpl instance;

    private RoomHistoryManagerImpl() {
    }

    public static RoomHistoryManagerImpl getInstance() {
        if (instance == null) {
            instance = new RoomHistoryManagerImpl();
        }
        return instance;
    }

    @Override
    public void addHistory(RoomHistory roomHistory) {
        RoomHistoryStorageImpl.getInstance().addRoomHistory(roomHistory);
    }

    @Override
    public void printRoomHistories() {
        List<RoomHistory> tempRoomHistories = RoomHistoryStorageImpl.getInstance().getRoomHistories();
        for (RoomHistory roomHistory : tempRoomHistories) {
            System.out.println(roomHistory);
        }
    }
}
