package action.guest;

import action.api.IAction;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;
import utils.InputReader;
import utils.Printer;

import java.util.Scanner;

public class BillGuestActionImpl implements IAction {
    private static Scanner scanner = new Scanner(System.in);
    private IStayInfoService stayInfoService = StayInfoServiceImpl.getInstance();


    @Override
    public void execute() {
        try {
            Printer.printStayInfo(stayInfoService.getMapStayInfo());
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
            System.out.println(stayInfoService.getBillForIdRoomAndIdGuest(guestId, roomId));
        } catch (Exception e) {
            System.out.println("Нет такого посетителя или счета" + e.getMessage());
        }
    }
}