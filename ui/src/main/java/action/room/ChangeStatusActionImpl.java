package action.room;

import action.api.IAction;
import ru.senla.enums.RoomStatus;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class ChangeStatusActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    private IRoomsService roomsService = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {
        roomsService.getListRooms().stream().forEach(System.out::println);
        int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
        RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                "Введите цифру статуса номера: " +
                        "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
        System.out.println(roomsService.changeRoomStatus(roomId, status));
    }
}
