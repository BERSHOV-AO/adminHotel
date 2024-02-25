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
    //    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();


    @Override
    public void execute() {
//        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
//            return;
//        }

//        System.out.println("-------All Guests-------");
//        guestsRepository.getAllGuests().stream().forEach(System.out::println);
        try {
            guestsService.getListGuests().stream().forEach(System.out::println);
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            System.out.println(guestsService.deletedGuestById(guestId));
//            int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
//            guestsRepository.deleteGuest(guestsRepository.getGuestById(guestId));
//            logger.info(String.format("Удален посетитель с id: %d ", guestId));
        } catch (Exception e) {
            System.out.println("Не удалось удалить посетителя " + e.getMessage());
            logger.warn("Не удалось удалить посетителя ", e);
        }
    }
}
