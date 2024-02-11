package controllers.room_history;

import models.Guest;
import models.Room;
import models.RoomHistory;

public interface RoomHistoryManager {
    public void addHistory(RoomHistory roomHistory);

    public void printRoomHistories();

    public void exportRoomHistoryToFileCSV();

    public RoomHistory getRoomHistoryByGuestAndRoom(Guest guest, Room room);

    public void deleteRoomHistoryByGuestAndRoom(Guest guest, Room room);
}
