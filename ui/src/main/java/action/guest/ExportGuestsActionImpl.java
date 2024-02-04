package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;

public class ExportGuestsActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        guestManager.exportGuestsToFileCSV();

    }
}
