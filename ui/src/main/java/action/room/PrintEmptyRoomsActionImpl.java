package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import utils.ExistsEntity;

public class PrintEmptyRoomsActionImpl implements IAction {
    @Override
    public void execute() {

        RoomManager roomManager = RoomManagerImpl.getInstance();
        if (ExistsEntity.noExistRooms(roomManager.getAllRooms())) {
            return;
        }
        System.out.println("-------Empty Rooms-------");
        roomManager.getEmptyRooms().stream().forEach(System.out::println);
    }
}
