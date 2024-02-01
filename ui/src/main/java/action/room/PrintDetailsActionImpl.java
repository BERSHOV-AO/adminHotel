package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class PrintDetailsActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);
        try {
            boolean roomExists = true;
            while (roomExists) {
                Integer roomId = InputReader.getIntegerInput(scanner,
                        "Введите id комнаты, для распечатки деталей:  ");
                boolean roomNumberExists = roomManager.checkRoomIDExists(roomId);
                if (!roomNumberExists) {
                    System.out.println("Комнаты с  id: " + roomId + " не существует! Введите корректный id!");
                } else {
                    System.out.println(roomManager.getRoomDetails(roomManager.getRoomById(roomId)));
                    roomExists = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
        }
    }
}
