package action.room;

import action.api.IAction;
import enums.RoomStatus;
import utils.InputReader;
import utils.LogicDetails;
import view.HotelManagerImpl;

import java.util.Scanner;

public class ChangeStatusImpl implements IAction {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllRooms();

        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            RoomStatus status = LogicDetails.integerRoomStatus(InputReader.getIntegerInput(scanner,
                    "Введите цифру статуса номера: 1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE"));
            HotelManagerImpl.getInstance().changeRoomStatus(HotelManagerImpl.getInstance()
                    .getRoomByNumber(roomNumber), status);
        } catch (Exception e) {
            System.out.println("Не удалось изменить статус номера " + e.getMessage());
        }
    }
}
