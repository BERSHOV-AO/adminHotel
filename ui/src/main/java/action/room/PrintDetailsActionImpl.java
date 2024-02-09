package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import utils.ExistsEntity;

public class PrintDetailsActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManager roomManager = RoomManagerImpl.getInstance();
        if (ExistsEntity.noExistRooms(roomManager.getAllRooms())) {
            return;
        }

        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);

        try {
            int roomId = ExistsEntity.getExistsRoomID(roomManager);
            System.out.println(roomManager.getRoomDetails(roomManager.getRoomById(roomId)));
        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
        }
    }
}
