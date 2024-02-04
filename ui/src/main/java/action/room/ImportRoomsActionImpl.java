package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class ImportRoomsActionImpl implements IAction {

    RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
    @Override
    public void execute() {
        roomManager.importCSVFilesToRooms();
    }
}
