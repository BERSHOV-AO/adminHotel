package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class PrintEmptyRoomsActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------Empty Rooms-------");
        RoomManagerImpl.getInstance().getEmptyRooms().stream().forEach(System.out::println);
    }
}
