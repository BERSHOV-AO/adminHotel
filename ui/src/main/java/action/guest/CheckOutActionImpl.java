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
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        Printer.printStayInfo(stayInfoManager.getMapStayInfo());
        String lastName = InputReader.getStringInput(scanner,
                "Введите имя посетителя, чтобы выселить ");
        Integer roomNumber = InputReader.getIntegerInput(scanner,
                "Введите номер комнаты: ");
        try {
            stayInfoManager.checkOutGuestFromRoom(guestManager.getGuestByName(lastName),
                    roomManager.getRoomByNumber(roomNumber));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
        }
    }
}
