package storages.room_history;

import models.RoomHistory;

import java.util.List;

public interface RoomHistoryStorage {
    public void addRoomHistory(RoomHistory history);

    public List<RoomHistory> getRoomHistories();
}
