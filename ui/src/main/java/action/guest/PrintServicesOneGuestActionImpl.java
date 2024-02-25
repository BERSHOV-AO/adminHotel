package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.entities.Service;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.List;
import java.util.Scanner;

public class PrintServicesOneGuestActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println("-------All Guests-------");
        guestsService.getListGuests().stream().forEach(System.out::println);
        int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
        System.out.println(guestsService.printServicesOneGuest(guestId));
    }
}
