package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import utils.InputReader;

import java.util.Scanner;

public class AddServicesToGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(AddServicesToGuestActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        try {
            System.out.println(guestsService.getListGuests());

            int guestId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");
            int serviceId = InputReader.getIntegerInput(scanner, "Введите id сервиса ");
            System.out.println(guestsService.addServicesToGuest(guestId, serviceId));
        } catch (Exception e) {
            System.out.println("Не удалось добавить сервис посетителю " + e.getMessage());
            logger.warn("Не удалось добавить сервис посетителю ", e);
        }
    }
}