package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.entities.Service;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.ExistsEntity;

import java.util.List;

public class PrintServicesOneGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(PrintServicesOneGuestActionImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }
        System.out.println("-------All Guests-------");
        guestsRepository.getAllGuests().stream().forEach(System.out::println);
        List<Service> listService;
        try {
            int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
            listService = guestsRepository.getGuestServices(
                    guestsRepository.getGuestById(guestId));

            StringBuilder str = new StringBuilder();
            str.append("Имя гостя: " + guestsRepository.getGuestById(guestId).getLastName() + "\n");
            str.append("Воспользовался услугами: " + "\n");
            str.append(listService.toString());
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Нет возможности распечатать сервис " + e.getMessage());
            logger.warn("Нет возможности распечатать сервис ", e);
        }
    }
}
