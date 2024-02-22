package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;
import utils.InputReader;
import utils.Printer;

import java.util.Scanner;

public class CheckOutActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(CheckOutActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IStayInfoService stayInfoService = StayInfoServiceImpl.getInstance();
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();


    @Override
    public void execute() {
        try {
            Printer.printStayInfo(stayInfoService.getMapStayInfo());
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
            System.out.println(guestsService.checkOutGuest(guestId, roomId));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
            logger.warn("Не удалось выселить посетителя ", e);
        }
    }
}
