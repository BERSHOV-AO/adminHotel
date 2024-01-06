package room;

import api.Action;
import enums.RoomStatus;
import models.Room;
import utils.InputReader;
import utils.LogicDetails;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddRoomImpl implements Action {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("-----Добавление номеров-----");
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты:  ");
            Integer capacity = InputReader.getIntegerInput(scanner, "Введите вместимость комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите стоимость номера за сутки ");
            Integer stars = InputReader.getIntegerInput(scanner,
                    "Введите количество звезд номера от 1 до 5 звезд");
            RoomStatus status = LogicDetails.integerRoomStatus(InputReader.getIntegerInput(scanner,
                    "Введите цифру статуса номера: 1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE"));

            HotelManagerImpl.getInstance().createRoom(new Room(roomNumber, stars, priceDay, capacity, status));

        } catch (Exception e) {
            System.out.println("Не удалось добавить комнату! Введите правильные параметры " + e.getMessage());
        }
    }
}
