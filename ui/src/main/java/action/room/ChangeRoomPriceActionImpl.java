package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeRoomPriceActionImpl implements IAction {

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
        } catch (Exception e) {
            System.out.println("Не удалось изменить цену номера " + e.getMessage());
        }
    }
}