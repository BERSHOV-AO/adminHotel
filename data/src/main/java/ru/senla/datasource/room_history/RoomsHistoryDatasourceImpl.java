package ru.senla.datasource.room_history;

import ru.senla.entities.RoomHistory;

import java.util.ArrayList;
import java.util.List;

public class RoomsHistoryDatasourceImpl implements IRoomsHistoryDatasource {
    private List<RoomHistory> roomHistories = new ArrayList<>();

    private static RoomsHistoryDatasourceImpl instance;

    private RoomsHistoryDatasourceImpl() {
    }

    public static RoomsHistoryDatasourceImpl getInstance() {
        if (instance == null) {
            instance = new RoomsHistoryDatasourceImpl();
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
