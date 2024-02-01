package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import enums.RoomStatus;
import utils.InputReader;

import java.util.Scanner;

public class ChangeStatusActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);
        try {
            boolean roomExists = true;
            while (roomExists) {
                Integer roomId = InputReader.getIntegerInput(scanner,
                        "Введите id комнаты для изменения статуса:  ");
                boolean roomNumberExists = roomManager.checkRoomIDExists(roomId);
                if (!roomNumberExists) {
                    System.out.println("Комнаты с  id: " + roomId + " не существует! Введите корректный id!");
                } else {
                    RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                            "Введите цифру статуса номера: " +
                                    "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
                    roomManager.changeRoomStatus(roomManager.getRoomById(roomId), status);
                    roomExists = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Не удалось изменить статус номера " + e.getMessage());
        }
    }
}
