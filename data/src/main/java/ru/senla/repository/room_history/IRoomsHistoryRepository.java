package ru.senla.repository.room_history;

import ru.senla.entities.Guest;
import ru.senla.entities.Room;
import ru.senla.entities.RoomHistory;

public interface IRoomsHistoryRepository {
    public void addHistory(RoomHistory roomHistory);

    public void printRoomHistories();

    public void exportRoomHistoryToFileCSV();

    public RoomHistory getRoomHistoryByGuestAndRoom(Guest guest, Room room);

    public void deleteRoomHistoryByGuestAndRoom(Guest guest, Room room);
}
