package utils;

import enums.RoomStars;
import enums.RoomStatus;
import enums.ServiceType;

public class LogicDetails {
    public static RoomStatus integerRoomStatus(Integer input) {
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

    public static RoomStars integerRoomStar(Integer input) {

        RoomStars roomStar = null;
        switch (input) {
            case 1:
                roomStar = RoomStars.STANDARD;
                break;
            case 2:
                roomStar = RoomStars.DELUXE;
                break;
            case 3:
                roomStar = RoomStars.EXECUTIVE;
                break;
            case 4:
                roomStar = RoomStars.SUITE;
                break;
            case 5:
                roomStar = RoomStars.PENTHOUSE;
                break;
            default:
                Printer.print("Неправильный ввод. Пожалуйста, введите число от 1 до 5.");
        }
        return roomStar;
    }

    public static ServiceType integerServiceType(Integer input) {

        ServiceType serviceType = null;
        switch (input) {
            case 1:
                serviceType = ServiceType.BREAKFAST;
                break;
            case 2:
                serviceType = ServiceType.LUNCH;
                break;
            case 3:
                serviceType = ServiceType.DINNER;
                break;
            case 4:
                serviceType = ServiceType.LAUNDRY;
                break;
            default:
                Printer.print("Неправильный ввод. Пожалуйста, введите число от 1 до 4.");
        }
        return serviceType;
    }
}
