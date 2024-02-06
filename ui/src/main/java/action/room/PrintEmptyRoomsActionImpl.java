package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class PrintEmptyRoomsActionImpl implements IAction {
    @Override
    public void execute() {

        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
        if (roomManager.getAllRooms().size() == 0) {
            System.out.println("Нет доступных комнат!");
            return;
        }
        System.out.println("-------Empty Rooms-------");
        roomManager.getEmptyRooms().stream().forEach(System.out::println);
    }
}
