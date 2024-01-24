package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import enums.RoomStatus;
import utils.InputReader;
import utils.LogicDetails;

import java.util.Scanner;

public class ChangeStatusActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);
        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            RoomStatus status = LogicDetails.integerRoomStatus(InputReader.getIntegerInput(scanner,
                    "Введите цифру статуса номера: 1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE"));
            roomManager.changeRoomStatus(roomManager.getRoomByNumber(roomNumber), status);
        } catch (Exception e) {
            System.out.println("Не удалось изменить статус номера " + e.getMessage());
        }
    }
}
