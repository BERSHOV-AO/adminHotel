package action.guest;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.guest.IGuestsService;
import ru.senla.stay_info.IStayInfoService;
import utils.InputReader;
import utils.Printer;

import java.util.Scanner;

public class CheckOutActionImpl implements IAction {
    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IStayInfoService stayInfoService;
    @InjectByType
    private IGuestsService guestsService;


    @Override
    public void execute() {
        try {
            Printer.printStayInfo(stayInfoService.getMapStayInfo());
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
            System.out.println(guestsService.checkOutGuest(guestId, roomId));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
        }
    }
}
