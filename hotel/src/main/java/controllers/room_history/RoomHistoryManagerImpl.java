//package controllers.room_history;
//
//import csv_utils.RoomHistoryExporter;
//import models.Guest;
//import models.Room;
//import models.RoomHistory;
//import storages.room_history.RoomHistoryStorage;
//import storages.room_history.RoomHistoryStorageImpl;
//
//import java.util.Iterator;
//import java.util.List;
//
//public class RoomHistoryManagerImpl implements RoomHistoryManager {
//
//    RoomHistoryStorage roomHistoryStorage = RoomHistoryStorageImpl.getInstance();
//
//    private static RoomHistoryManagerImpl instance;
//
//    private RoomHistoryManagerImpl() {
//    }
//
//    public static RoomHistoryManagerImpl getInstance() {
//        if (instance == null) {
//            instance = new RoomHistoryManagerImpl();
//        }
//        return instance;
//    }
//
//    @Override
//    public void addHistory(RoomHistory roomHistory) {
//        roomHistoryStorage.addRoomHistory(roomHistory);
//    }
//
//    @Override
//    public void printRoomHistories() {
//        List<RoomHistory> tempRoomHistories = roomHistoryStorage.getRoomHistories();
//        for (RoomHistory roomHistory : tempRoomHistories) {
//            System.out.println(roomHistory);
//        }
//    }
//
//    @Override
//    public void exportRoomHistoryToFileCSV() {
//        RoomHistoryExporter.exportRoomsHistory(roomHistoryStorage.getRoomHistories());
//    }
//
//    @Override
//    public RoomHistory getRoomHistoryByGuestAndRoom(Guest guest, Room room) {
//        List<RoomHistory> roomHistories = roomHistoryStorage.getRoomHistories();
//        return roomHistories.stream()
//                .filter(roomHistory -> roomHistory.getGuest().getId() == guest.getId() &&
//                        roomHistory.getRoom().getId() == room.getId())
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public void deleteRoomHistoryByGuestAndRoom(Guest guest, Room room) {
//        List<RoomHistory> roomHistories = roomHistoryStorage.getRoomHistories();
//        Iterator<RoomHistory> iterator = roomHistories.iterator();
//        while (iterator.hasNext()) {
//            RoomHistory roomHistory = iterator.next();
//            if (roomHistory.getGuest().getId() == guest.getId() &&
//                    roomHistory.getRoom().getId() == room.getId()) {
//                iterator.remove();
//            }
//        }
//    }
//}
//
