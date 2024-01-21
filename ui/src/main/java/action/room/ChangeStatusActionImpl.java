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

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        RoomManagerImpl.getInstance().getAllRooms().stream().forEach(System.out::println);
        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            RoomStatus status = LogicDetails.integerRoomStatus(InputReader.getIntegerInput(scanner,
                    "Введите цифру статуса номера: 1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE"));
            RoomManagerImpl.getInstance().changeRoomStatus(RoomManagerImpl.getInstance()
                    .getRoomByNumber(roomNumber), status);
        } catch (Exception e) {
            System.out.println("Не удалось изменить статус номера " + e.getMessage());
        }
    }
}
