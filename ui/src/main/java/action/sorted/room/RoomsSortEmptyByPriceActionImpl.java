package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortEmptyByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        System.out.println("-------Sorted empty rooms by price-------");
        roomManager.getFreeRooms(roomManager.getSortedRoomsByPrice()).stream().forEach(System.out::println);
    }
}
