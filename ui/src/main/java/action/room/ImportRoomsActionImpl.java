package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;

public class ImportRoomsActionImpl implements IAction {

    RoomManager roomManager = RoomManagerImpl.getInstance();

    @Override
    public void execute() {
        roomManager.importCSVFilesToRooms();
    }
}
