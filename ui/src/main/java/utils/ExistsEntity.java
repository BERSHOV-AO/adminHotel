package utils;

import controllers.guest.GuestManager;
import controllers.room.RoomManager;
import controllers.service.ServiceManager;
import models.Guest;
import models.Room;
import models.Service;
import models.StayInfo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExistsEntity {

    private static Scanner scanner = new Scanner(System.in);

    public static int getExistsRoomID(RoomManager roomManager) {
        int roomId;
        boolean roomExists;
        do {
            roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
            roomExists = roomManager.checkRoomIDExists(roomId);
            if (!roomExists) {
                System.out.println("Комнаты с id: " + roomId + " не существует! Введите корректный id!");
            }
        } while (!roomExists);
        return roomId;
    }

    public static int getExistsGuestID(GuestManager guestManager) {
        int guestId;
        boolean roomExists;
        do {
            guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            roomExists = guestManager.checkGuestIDExists(guestId);
            if (!roomExists) {
                System.out.println("Посетителя с id: " + guestId + " не существует! Введите корректный id!");
            }
        } while (!roomExists);
        return guestId;
    }

    public static int getExistsServiceID(ServiceManager serviceManager) {

        int serviceId;
        boolean serviceExists;
        do {
            serviceId = InputReader.getIntegerInput(scanner, "Введите id сервиса ");
            serviceExists = serviceManager.checkServiceIDExists(serviceId);
            if (!serviceExists) {
                System.out.println("Сервиса с id: " + serviceId + " не существует! Введите корректный id!");
            }
        } while (!serviceExists);
        return serviceId;
    }

    public static boolean noExistGuests(List<Guest> guestList) {
        if (guestList.size() == 0) {
            System.out.println("Нет доступных гостей!");
            return true;
        }
        return false;
    }

    public static boolean noExistRooms(List<Room> roomList) {
        if (roomList.size() == 0) {
            System.out.println("Нет доступных комнат!");
            return true;
        }
        return false;
    }

    public static boolean noExistServices(List<Service> serviceList) {
        if (serviceList.size() == 0) {
            System.out.println("Нет доступных сервисов!");
            return true;
        }
        return false;
    }

    public static boolean noExistStayInfo(Map<Integer, StayInfo> mapStayInfo) {
        if (mapStayInfo.size() == 0) {
            System.out.println("Нет доступной информации о проживании!");
            return true;
        }
        return false;
    }
}