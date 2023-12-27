package room;

import api.Action;
import enums.RoomStars;
import enums.RoomStatus;
import models.Room;
import utils.InputReader;
import utils.Printer;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddRoomImpl implements Action {

    RoomStatus integerRoomStatus(Integer input) {
        RoomStatus roomStatus = null;

        switch (input) {
            case 1:
                roomStatus = RoomStatus.EMPTY;
                break;
            case 2:
                roomStatus = RoomStatus.OCCUPIED;
                break;
            case 3:
                roomStatus = RoomStatus.UNDER_REPAIR;
                break;
            case 4:
                roomStatus = RoomStatus.SERVICE;
                break;
            default:
                Printer.print("Неправильный ввод. Пожалуйста, введите число от 1 до 4.");
        }
        return roomStatus;
    }

//    RoomStars integerRoomStar(Integer input) {
//
//        RoomStars roomStar = null;
//        switch (input) {
//            case 1:
//                roomStar = RoomStars.STANDARD;
//                break;
//            case 2:
//                roomStar = RoomStars.DELUXE;
//                break;
//            case 3:
//                roomStar = RoomStars.EXECUTIVE;
//                break;
//            case 4:
//                roomStar = RoomStars.SUITE;
//                break;
//            case 5:
//                roomStar = RoomStars.PENTHOUSE;
//                break;
//            default:
//                Printer.print("Неправильный ввод. Пожалуйста, введите число от 1 до 5.");
//        }
//        return roomStar;
//    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты:  ");
            Integer capacity = InputReader.getIntegerInput(scanner, "Введите вместимость комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите стоимость номера за сутки ");
            // RoomStars stars = integerRoomStar(InputReader.getIntegerInput(scanner,
            //         "Введите количество звезд номера "));
            Integer stars = InputReader.getIntegerInput(scanner,
                    "Введите количество звезд номера от 1 до 5 звезд");
            RoomStatus status = integerRoomStatus(InputReader.getIntegerInput(scanner,
                    "Введите цифру статуса номера: 1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE"));

            HotelManagerImpl.getInstance().createRoom(new Room(roomNumber, stars, priceDay, capacity, status));

        } catch (Exception e) {
            System.out.println("Не удалось добавить комнату! Введите правильные параметры " + e.getMessage());
        }
    }
}
