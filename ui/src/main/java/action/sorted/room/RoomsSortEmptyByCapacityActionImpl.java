package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortEmptyByCapacityActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
        if (roomManager.getAllRooms().size() == 0) {
            System.out.println("Нет доступных комнат!");
            return;
        }

        System.out.println("-------Sorted empty rooms by capacity-------");
        roomManager.getFreeRooms(roomManager.getSortedRoomsByCapacity()).stream().forEach(System.out::println);
    }
}
