package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class ExportRoomsActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ExportRoomsActionImpl.class);

    @Override
    public void execute() {
        RoomManager roomManager = RoomManagerImpl.getInstance();
        if (ExistsEntity.noExistRooms(roomManager.getAllRooms())) {
            return;
        }
        try {
            roomManager.exportRoomsToFileCSV();
            System.out.println("Комнаты успешно экспортированы!");
            logger.info("Комнаты успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Комнаты не экспортированы!" + e.getMessage());
            logger.warn("Комнаты не экспортированы!", e);
        }
    }
}
