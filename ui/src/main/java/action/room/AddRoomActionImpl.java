package action.room;

import action.api.IAction;
import ru.senla.enums.RoomStatus;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class AddRoomActionImpl implements IAction {
    private static Scanner scanner = new Scanner(System.in);
    private IRoomsService roomsService = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {
        int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
        Integer capacity = InputReader.getIntegerInput(scanner, "Введите вместимость комнаты: ");
        Double priceDay = InputReader.getDoubleInput(scanner, "Введите стоимость номера за сутки ");
        Integer stars = InputReader.getIntegerInput(scanner,
                "Введите количество звезд номера от 1 до 5 звезд");
        RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                "Введите цифру статуса номера: " +
                        "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
        System.out.println(roomsService.addRoom(roomId, capacity, priceDay, stars, status));
    }
}
