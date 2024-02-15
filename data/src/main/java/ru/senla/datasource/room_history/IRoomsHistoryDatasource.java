package ru.senla.datasource.room_history;

import ru.senla.entities.RoomHistory;

import java.util.List;

public interface IRoomsHistoryDatasource {
    public void addRoomHistory(RoomHistory history);

    public List<RoomHistory> getRoomHistories();
}
