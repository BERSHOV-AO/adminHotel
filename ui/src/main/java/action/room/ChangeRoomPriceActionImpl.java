package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeRoomPriceActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ChangeRoomPriceActionImpl.class);

    @Override
    public void execute() {

        RoomManager roomManager = RoomManagerImpl.getInstance();
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
               logger.info(String.format("Стоимость номера с id %d, изменена на: %.2f", roomId,  priceDay));
        } catch (Exception e) {
            System.out.println("Не удалось изменить цену номера " + e.getMessage());
            logger.warn("Не удалось изменить цену номера ",  e);
        }
    }
}