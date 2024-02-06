package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class PrintRoomsActionImpl implements IAction {

    @Override
    public void execute() {

        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
        if (roomManager.getAllRooms().size() == 0) {
            System.out.println("Нет доступных комнат!");
            return;
        }
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);
    }
}
