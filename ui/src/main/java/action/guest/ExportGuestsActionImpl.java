package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class ExportGuestsActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ExportGuestsActionImpl.class);

    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();
        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }
        try {
            guestManager.exportGuestsToFileCSV();
            System.out.println("Посетители успешно экспортированы!");
            logger.info("Посетители успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Посетители не экспортированы!" + e.getMessage());
            logger.error("Посетители не экспортированы!", e);
            e.printStackTrace();
        }
    }
}
