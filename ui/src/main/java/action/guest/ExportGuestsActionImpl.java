package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;

public class ExportGuestsActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }
        guestManager.exportGuestsToFileCSV();
    }
}
