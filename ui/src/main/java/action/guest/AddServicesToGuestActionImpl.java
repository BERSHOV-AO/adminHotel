package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class AddServicesToGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(AddServicesToGuestActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();
    private IServicesService servicesService = ServicesServiceImpl.getInstance();

    @Override
    public void execute() {
        try {
            guestsService.getListGuests().stream().forEach(System.out::println);
            servicesService.getListServices().stream().forEach(System.out::println);

            int guestId = InputReader.getIntegerInput(scanner, "Введите id гостя: ");
            int serviceId = InputReader.getIntegerInput(scanner, "Введите id сервиса: ");
            System.out.println(guestsService.addServicesToGuest(guestId, serviceId));
        } catch (Exception e) {
            System.out.println("Не удалось добавить сервис посетителю " + e.getMessage());
            logger.warn("Не удалось добавить сервис посетителю ", e);
        }
    }
}