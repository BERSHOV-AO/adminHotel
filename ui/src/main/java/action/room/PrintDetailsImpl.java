package action.room;

import action.api.IAction;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class PrintDetailsImpl implements IAction {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllRooms();
        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            HotelManagerImpl.getInstance().printDetailsOfRoom(HotelManagerImpl.getInstance()
                    .getRoomByNumber(roomNumber));

        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
        }
    }
}
