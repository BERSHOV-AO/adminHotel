package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class ChangeRoomPriceActionImpl implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        RoomManagerImpl.getInstance().getAllRooms().stream().forEach(System.out::println);

        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите новую стоимость номера за сутки ");

            RoomManagerImpl.getInstance().changeRoomPrice(RoomManagerImpl.getInstance().getRoomByNumber(roomNumber),
                    priceDay);
        } catch (Exception e) {
            System.out.println("Не удалось изменить цену номера " + e.getMessage());
        }
    }
}