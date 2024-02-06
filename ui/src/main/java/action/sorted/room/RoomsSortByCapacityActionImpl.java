package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortByCapacityActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
        if (roomManager.getAllRooms().size() == 0) {
            System.out.println("Нет доступных комнат!");
            return;
        }

        System.out.println("-------Sorted rooms by capacity-------");
        roomManager.getSortedRoomsByCapacity().stream().forEach(System.out::println);
    }
}
