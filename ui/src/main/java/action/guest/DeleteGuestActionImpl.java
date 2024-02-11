package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class DeleteGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(DeleteGuestActionImpl.class);

    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();

        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }

        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        try {
            int guestId = ExistsEntity.getExistsGuestID(guestManager);
            guestManager.deleteGuest(guestManager.getGuestById(guestId));
        } catch (Exception e) {
            System.out.println("Не удалось удалить посетителя " + e.getMessage());
            logger.error("Не удалось удалить посетителя ", e);
        }
    }
}
