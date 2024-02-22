package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import utils.InputReader;

import java.util.Scanner;

public class AddGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(AddGuestActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        try {
            String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя, для добавления..");
            System.out.println(guestsService.addGuest(lastName));
        } catch (Exception e) {
            System.out.println("Не удалось добавить посетителя. Введите допустимые параметры!" + e.getMessage());
            logger.warn("Не удалось добавить посетителя. Введите допустимые параметры!", e);
        }
    }
}
