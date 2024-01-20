package controllers.room_history;

import models.RoomHistory;

public interface RoomHistoryManager {
    public void addHistory(RoomHistory roomHistory);

    public void printRoomHistories();
}
