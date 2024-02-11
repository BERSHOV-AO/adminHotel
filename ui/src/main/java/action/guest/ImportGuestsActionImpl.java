package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;

public class ImportGuestsActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();
        guestManager.importCSVFilesToGuests();
    }
}
