package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import utils.ExistsEntity;

public class RoomsSortByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManager roomManager = RoomManagerImpl.getInstance();
        if (ExistsEntity.noExistRooms(roomManager.getAllRooms())) {
            return;
        }
        System.out.println("-------Sorted rooms by price-------");
        roomManager.getSortedRoomsByPrice().stream().forEach(System.out::println);
    }
}
