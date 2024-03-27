package action.guest;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.guest.IGuestsService;
import ru.senla.service.IServicesService;
import utils.InputReader;

import java.util.Scanner;

public class AddServicesToGuestActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IGuestsService guestsService;
    @InjectByType
    private IServicesService servicesService;

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
        }
    }
}