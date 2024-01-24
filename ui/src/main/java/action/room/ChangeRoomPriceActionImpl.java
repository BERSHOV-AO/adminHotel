package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class ChangeRoomPriceActionImpl implements IAction {

    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);
        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите новую стоимость номера за сутки ");
            roomManager.changeRoomPrice(roomManager.getRoomByNumber(roomNumber),
                    priceDay);
        } catch (Exception e) {
            System.out.println("Не удалось изменить цену номера " + e.getMessage());
        }
    }
}