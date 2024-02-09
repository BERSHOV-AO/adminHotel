package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import utils.ExistsEntity;

public class DeleteGuestActionImpl implements IAction {
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
            System.out.println("Посетитель не удален " + e.getMessage());
        }
    }
}
