package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class DeleteGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(DeleteGuestActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();


    @Override
    public void execute() {
        try {
            guestsService.getListGuests().stream().forEach(System.out::println);
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            System.out.println(guestsService.deletedGuestById(guestId));
        } catch (Exception e) {
            System.out.println("Не удалось удалить посетителя " + e.getMessage());
            logger.warn("Не удалось удалить посетителя ", e);
        }
    }
}
