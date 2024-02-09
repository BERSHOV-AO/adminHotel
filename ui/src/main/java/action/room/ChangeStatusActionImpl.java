package action.room;

import action.api.IAction;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import enums.RoomStatus;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeStatusActionImpl implements IAction {
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
            RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                    "Введите цифру статуса номера: " +
                            "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
            roomManager.changeRoomStatus(roomManager.getRoomById(roomId), status);
        } catch (Exception e) {
            System.out.println("Не удалось изменить статус номера " + e.getMessage());
        }
    }
}
