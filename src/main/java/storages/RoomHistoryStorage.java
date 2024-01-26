package storages;

import models.RoomHistory;

import java.util.ArrayList;
import java.util.List;

public class RoomHistoryStorage {

    private List<RoomHistory> roomHistories = new ArrayList<>();

    public void addRoomHistory(RoomHistory history) {
        roomHistories.add(history);
    }

    public List<RoomHistory> getRoomHistories() {
        return roomHistories;
    }
}
