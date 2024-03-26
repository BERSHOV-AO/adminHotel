package ru.senla.repository.room_history;

import ru.senla.ConfigurationType;
import ru.senla.InjectDependency;
import ru.senla.datasource.room_history.IRoomsHistoryDatasource;
import ru.senla.datasource.room_history.RoomsHistoryDatasourceImpl;
import ru.senla.di_factory.InjectByType;
import ru.senla.di_factory.ObjectFactory;
import ru.senla.di_factory.Singleton;
import ru.senla.entities.Guest;
import ru.senla.entities.Room;
import ru.senla.entities.RoomHistory;
import ru.senla.utils.csv_utils.RoomHistoryExporter;

import java.util.Iterator;
import java.util.List;

@Singleton
public class RoomsHistoryRepositoryImpl implements IRoomsHistoryRepository {

  //  @InjectDependency(ConfigurationType.DATASOURCE_ROOM_HISTORY)
  //  IRoomsHistoryDatasource roomsHistoryDatasource = RoomsHistoryDatasourceImpl.getInstance();
  @InjectByType
  IRoomsHistoryDatasource roomsHistoryDatasource; // = ObjectFactory.getInstance().createObject(IRoomsHistoryDatasource.class);

    private static RoomsHistoryRepositoryImpl instance;

    public RoomsHistoryRepositoryImpl() {
    }

    public static RoomsHistoryRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RoomsHistoryRepositoryImpl();
        }
        return instance;
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
