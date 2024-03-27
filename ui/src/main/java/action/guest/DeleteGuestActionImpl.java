package action.guest;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.guest.IGuestsService;
import utils.InputReader;

import java.util.Scanner;

public class DeleteGuestActionImpl implements IAction {
    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IGuestsService guestsService;


    @Override
    public void execute() {
        try {
            guestsService.getListGuests().stream().forEach(System.out::println);
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            System.out.println(guestsService.deletedGuestById(guestId));
        } catch (Exception e) {
            System.out.println("Не удалось удалить посетителя " + e.getMessage());
        }
    }
}
