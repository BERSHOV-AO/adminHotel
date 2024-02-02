package utils;

import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.service.ServiceManagerImpl;

import java.util.Scanner;

public class ExistsEntity {
    private static RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
    private static GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
    private static ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static int getExistsRoomID() {
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

    public static int getExistsGuestID() {
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

    public static int getExistsServiceID() {

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
}
