package action.room;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;

public class ImportRoomsActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(ImportRoomsActionImpl.class);
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        try {
            roomsRepository.importCSVFilesToRooms();
            System.out.println("Комнаты успешно импортированы!");
            logger.info("Комнаты успешно импортированы!");
        } catch (Exception e) {
            System.out.println("Комнаты не импортированы!" + e.getMessage());
            logger.warn("Комнаты не импортированы!" + e.getMessage());
        }
    }
}
