package action.room;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class PrintDetailsActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(PrintDetailsActionImpl.class);
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistRooms(roomsRepository.getAllRooms())) {
            return;
        }

        System.out.println("-------All Rooms-------");
        roomsRepository.getAllRooms().stream().forEach(System.out::println);

        try {
            int roomId = ExistsEntity.getExistsRoomID(roomsRepository);
            System.out.println(roomsRepository.getRoomDetails(roomsRepository.getRoomById(roomId)));
        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
            logger.warn("Нет возможности показать детали номера ", e);
        }
    }
}
