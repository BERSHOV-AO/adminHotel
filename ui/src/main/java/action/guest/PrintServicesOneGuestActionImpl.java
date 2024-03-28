package action.guest;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.guest.IGuestsService;
import utils.InputReader;

import java.util.Scanner;

public class PrintServicesOneGuestActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IGuestsService guestsService;

    @Override
    public void execute() {
        System.out.println("-------All Guests-------");
        guestsService.getListGuests().stream().forEach(System.out::println);
        int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
        System.out.println(guestsService.printServicesOneGuest(guestId));
    }
}
