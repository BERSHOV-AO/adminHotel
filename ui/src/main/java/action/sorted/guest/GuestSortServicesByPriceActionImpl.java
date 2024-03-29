package action.sorted.guest;

import action.api.IAction;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import utils.InputReader;

import java.util.Scanner;

public class GuestSortServicesByPriceActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println("-------All Guests-------");
        guestsService.getListGuests().stream().forEach(System.out::println);
        int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
        System.out.println(String.format("У посетителя с id: %d , сортированные сервисы по цене:", guestId));
        guestsService.getListServicesOneGuestSortPriceByGuestId(guestId).stream().forEach(System.out::println);
    }
}
