package action.room;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class ExportRoomsActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(ExportRoomsActionImpl.class);
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistRooms(roomsRepository.getAllRooms())) {
            return;
        }
        try {
            roomsRepository.exportRoomsToFileCSV();
            System.out.println("Комнаты успешно экспортированы!");
            logger.info("Комнаты успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Комнаты не экспортированы!" + e.getMessage());
            logger.warn("Комнаты не экспортированы!", e);
        }
    }
}
