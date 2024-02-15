package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.ExistsEntity;

public class DeleteGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(DeleteGuestActionImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }

        System.out.println("-------All Guests-------");
        guestsRepository.getAllGuests().stream().forEach(System.out::println);
        try {
            int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
            guestsRepository.deleteGuest(guestsRepository.getGuestById(guestId));
            logger.info(String.format("Удален посетитель с id: %d ", guestId));
        } catch (Exception e) {
            System.out.println("Не удалось удалить посетителя " + e.getMessage());
            logger.warn("Не удалось удалить посетителя ", e);
        }
    }
}
