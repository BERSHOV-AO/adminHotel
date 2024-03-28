package ru.senla.repository.room_history;

import ru.senla.datasource.room_history.IRoomsHistoryDatasource;
import ru.senla.di.InjectByType;
import ru.senla.di.Singleton;
import ru.senla.entities.Guest;
import ru.senla.entities.Room;
import ru.senla.entities.RoomHistory;
import ru.senla.utils.csv_utils.RoomHistoryExporter;

import java.util.Iterator;
import java.util.List;

@Singleton
public class RoomsHistoryRepositoryImpl implements IRoomsHistoryRepository {

    @InjectByType
    IRoomsHistoryDatasource roomsHistoryDatasource;

    public RoomsHistoryRepositoryImpl() {
    }

    @Override
    public void addHistory(RoomHistory roomHistory) {
        roomsHistoryDatasource.addRoomHistory(roomHistory);
    }

    @Override
    public void printRoomHistories() {
        List<RoomHistory> tempRoomHistories = roomsHistoryDatasource.getRoomHistories();
        for (RoomHistory roomHistory : tempRoomHistories) {
            System.out.println(roomHistory);
        }
    }

    @Override
    public void exportRoomHistoryToFileCSV() {
        RoomHistoryExporter.exportRoomsHistory(roomsHistoryDatasource.getRoomHistories());
    }

    @Override
    public RoomHistory getRoomHistoryByGuestAndRoom(Guest guest, Room room) {
        List<RoomHistory> roomHistories = roomsHistoryDatasource.getRoomHistories();
        return roomHistories.stream()
                .filter(roomHistory -> roomHistory.getGuest().getId() == guest.getId() &&
                        roomHistory.getRoom().getId() == room.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteRoomHistoryByGuestAndRoom(Guest guest, Room room) {
        List<RoomHistory> roomHistories = roomsHistoryDatasource.getRoomHistories();
        Iterator<RoomHistory> iterator = roomHistories.iterator();
        while (iterator.hasNext()) {
            RoomHistory roomHistory = iterator.next();
            if (roomHistory.getGuest().getId() == guest.getId() &&
                    roomHistory.getRoom().getId() == room.getId()) {
                iterator.remove();
            }
        }
    }
}
