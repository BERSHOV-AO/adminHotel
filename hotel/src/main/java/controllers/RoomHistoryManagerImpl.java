package controllers;

import api.controllers.RoomHistoryManager;
import models.RoomHistory;
import storages.RoomHistoryStorageImpl;

import java.util.List;

public class RoomHistoryManagerImpl implements RoomHistoryManager {

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
