package ru.senla.datasource.room_history;

import ru.senla.di.Singleton;
import ru.senla.entities.RoomHistory;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RoomsHistoryDatasourceImpl implements IRoomsHistoryDatasource {
    private List<RoomHistory> roomHistories = new ArrayList<>();


    public RoomsHistoryDatasourceImpl() {
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
