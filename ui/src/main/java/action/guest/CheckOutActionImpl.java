package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.InputReader;
import utils.Printer;

import java.util.Scanner;

public class CheckOutActionImpl implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        Printer.printStayInfo(StayInfoManagerImpl.getInstance().getMapStayInfo());

        String lastName = InputReader.getStringInput(scanner,
                "Введите имя посетителя, чтобы выселить ");

        Integer roomNumber = InputReader.getIntegerInput(scanner,
                "Введите номер комнаты: ");

        try {
            StayInfoManagerImpl.getInstance().checkOutGuestFromRoom(GuestManagerImpl.getInstance().getGuestByName(lastName),
                    RoomManagerImpl.getInstance().getRoomByNumber(roomNumber));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
        }
    }
}
