package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import utils.ExistsEntity;

public class ExportGuestsActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();

        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }
        guestManager.exportGuestsToFileCSV();
    }
}
