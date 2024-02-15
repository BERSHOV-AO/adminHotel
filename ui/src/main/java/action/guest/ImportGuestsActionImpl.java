package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;

public class ImportGuestsActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(ImportGuestsActionImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        try {
            guestsRepository.importCSVFilesToGuests();
            System.out.println("Посетители успешно импортированы!");
            logger.info("Посетители успешно импортированы!");
        } catch (Exception e) {
            System.out.println("Посетители не импортированы!" + e.getMessage());
            logger.warn("Посетители не импортированы!" + e.getMessage());
        }
    }
}
