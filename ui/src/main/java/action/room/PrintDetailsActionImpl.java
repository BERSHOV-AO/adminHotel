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
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            roomManager.getRoomDetails(roomManager.getRoomByNumber(roomNumber));
        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
        }
    }
}
