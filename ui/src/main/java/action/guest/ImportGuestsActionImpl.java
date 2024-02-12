package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import org.apache.log4j.Logger;

public class ImportGuestsActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ImportGuestsActionImpl.class);

    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();

        try {
            guestManager.importCSVFilesToGuests();
            System.out.println("Посетители успешно импортированы!");
            logger.info("Посетители успешно импортированы!");
        } catch (Exception e) {
            System.out.println("Посетители не импортированы!" + e.getMessage());
            logger.warn("Посетители не импортированы!" + e.getMessage());
        }
    }
}
