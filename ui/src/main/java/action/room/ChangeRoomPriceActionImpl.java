package action.room;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeRoomPriceActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(ChangeRoomPriceActionImpl.class);
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
            Double priceDay = InputReader.getDoubleInput(scanner,
                    "Введите новую стоимость номера за сутки ");
            roomManager.changeRoomPrice(roomManager.getRoomById(roomId),
                    priceDay);
            logger.info(String.format("Стоимость номера с id %d, изменена на: %.2f", roomId, priceDay));
        } catch (Exception e) {
            System.out.println("Не удалось изменить цену номера " + e.getMessage());
            logger.warn("Не удалось изменить цену номера ", e);
        }
    }
}