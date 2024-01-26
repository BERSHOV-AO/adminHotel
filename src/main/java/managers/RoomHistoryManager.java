package managers;

import models.RoomHistory;
import storages.RoomHistoryStorage;

import java.util.List;

public class RoomHistoryManager {
    RoomHistoryStorage roomHistoryStorage = new RoomHistoryStorage();

    public void addHistory(RoomHistory roomHistory) {
        roomHistoryStorage.addRoomHistory(roomHistory);
    }

    public void printRoomHistories() {
        List<RoomHistory> tempRoomHistories = roomHistoryStorage.getRoomHistories();
        for (RoomHistory roomHistory : tempRoomHistories) {
            System.out.println(roomHistory);
        }
    }
}
