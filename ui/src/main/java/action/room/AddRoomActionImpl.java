package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import enums.RoomStatus;
import models.Room;
import utils.InputReader;

import java.util.Scanner;

public class AddRoomActionImpl implements IAction {

    @Override
    public void execute() {

        try {
            RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
            Scanner scanner = new Scanner(System.in);

            int roomNumber;
            boolean roomExists;
            do {
                roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
                roomExists = roomManager.checkRoomNumberExists(roomNumber);
                if (roomExists) {
                    System.out.println("Комната с номером: " + roomNumber +
                            " уже существует! Введите другой номер комнаты");
                }
            } while (roomExists);

            Integer capacity = InputReader.getIntegerInput(scanner, "Введите вместимость комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите стоимость номера за сутки ");
            Integer stars = InputReader.getIntegerInput(scanner,
                    "Введите количество звезд номера от 1 до 5 звезд");
            RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                    "Введите цифру статуса номера: " +
                            "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
            roomManager.addRoom(new Room(roomNumber, stars, priceDay, capacity, status));
        } catch (Exception e) {
            System.out.println("Не удалось добавить комнату! Введите правильные параметры " + e.getMessage());
        }
    }
}
