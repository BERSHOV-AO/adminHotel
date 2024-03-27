package action.room;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class ChangeRoomPriceActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IRoomsService roomsService; // = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {

        roomsService.getListRooms().stream().forEach(System.out::println);
        int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
        Double priceNew = InputReader.getDoubleInput(scanner, "Введите новую стоимость номера за сутки ");
        System.out.println(roomsService.changeRoomPrice(roomId, priceNew));
    }
}