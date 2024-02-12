package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import org.apache.log4j.Logger;

public class ImportRoomsActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ImportRoomsActionImpl.class);

    @Override
    public void execute() {
        RoomManager roomManager = RoomManagerImpl.getInstance();
        try {
            roomManager.importCSVFilesToRooms();
            System.out.println("Комнаты успешно импортированы!");
            logger.info("Комнаты успешно импортированы!");
        } catch (Exception e) {
            System.out.println("Комнаты не импортированы!" + e.getMessage());
            logger.warn("Комнаты не импортированы!" + e.getMessage());
        }
    }
}
