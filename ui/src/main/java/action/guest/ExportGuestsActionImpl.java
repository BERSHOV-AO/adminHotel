package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.ExistsEntity;

public class ExportGuestsActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(ExportGuestsActionImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }
        try {
            guestsRepository.exportGuestsToFileCSV();
            System.out.println("Посетители успешно экспортированы!");
            logger.info("Посетители успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Посетители не экспортированы!" + e.getMessage());
            logger.warn("Посетители не экспортированы!", e);
        }
    }
}
