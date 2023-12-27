package api.controllers;

import models.RoomHistory;

public interface RoomHistoryManager {
    public void addHistory(RoomHistory roomHistory);

    public void printRoomHistories();
}
