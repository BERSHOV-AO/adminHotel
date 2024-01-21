package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class PrintDetailsActionImpl implements IAction {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Rooms-------");
        RoomManagerImpl.getInstance().getAllRooms().stream().forEach(System.out::println);
        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            RoomManagerImpl.getInstance().getRoomDetails(RoomManagerImpl.getInstance()
                    .getRoomByNumber(roomNumber));
        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
        }
    }
}
