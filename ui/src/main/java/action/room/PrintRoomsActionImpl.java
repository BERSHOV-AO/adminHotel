package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class PrintRoomsActionImpl implements IAction {

    @Override
    public void execute() {
        System.out.println("-------All Rooms-------");
        RoomManagerImpl.getInstance().getAllRooms().stream().forEach(System.out::println);
    }
}
