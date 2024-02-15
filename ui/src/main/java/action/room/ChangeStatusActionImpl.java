package action.room;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.enums.RoomStatus;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeStatusActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(ChangeStatusActionImpl.class);
    private IRoomsRepository roomManager = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistRooms(roomManager.getAllRooms())) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);

        try {
            int roomId = ExistsEntity.getExistsRoomID(roomManager);
            RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                    "Введите цифру статуса номера: " +
                            "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
            roomManager.changeRoomStatus(roomManager.getRoomById(roomId), status);
            logger.info(String.format("Статус номера с id %d, изменена на: " + status, roomId));
        } catch (Exception e) {
            System.out.println("Не удалось изменить статус номера " + e.getMessage());
            logger.warn("Не удалось изменить статус номера ", e);
        }
    }
}
